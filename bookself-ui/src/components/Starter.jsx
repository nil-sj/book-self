import React, { useState, useEffect } from "react";
import { fetchStarters } from "../services/starterService";

export const Starter = () => {
  const [starters, setStarters] = useState([]);
  const [errorMessage, setErrorMessage] = useState(null);

  useEffect(() => {
    fetchStarters()
      .then((data) => {
        setStarters(data);
      })
      .catch((error) => {
        console.error("Error fetching starters:", error);
        setErrorMessage("Failed to fetch starters. Please try again later.");
      });
  }, []);

  const handleRefreshStarters = () => {
    fetchStarters()
      .then((data) => {
        setStarters(data);
      })
      .catch((error) => {
        console.error("Error refreshing starters:", error);
        setErrorMessage("Failed to refresh starters. Please try again later.");
      });
  };

  return (
    <div className="mt-5 container">
      <div className="card">
        <div className="card-header">Fetched Message</div>
        <div className="card-body">
          {errorMessage ? (
            <p className="text-danger">{errorMessage}</p>
          ) : (
            <p>{starters.length > 0 ? starters.map((starter, id) => <span key={id}>{starter.message}<br/></span>) : "No starters available."}</p>
          )}
          <button className="btn btn-primary mt-3" onClick={handleRefreshStarters}>
            Refresh Starters
          </button>
        </div>
      </div>
    </div>
  );
};
