import React, { useState } from 'react';

function TableSection({ countryData }) {
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage, setItemsPerPage] = useState(10);
  const [sortColumn, setSortColumn] = useState(null);
  const [sortDirection, setSortDirection] = useState(null);
  const [searchQuery, setSearchQuery] = useState('');

  // Calculate the index of the last item on the current page
  const indexOfLastItem = currentPage * itemsPerPage;
  // Calculate the index of the first item on the current page
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  // Get the current items for the current page
  const currentItems = countryData
    .filter((country) =>
      country.country.toLowerCase().includes(searchQuery.toLowerCase())
    )
    .sort((a, b) => {
      if (sortColumn === null) return 0;
      const aValue = a[sortColumn];
      const bValue = b[sortColumn];
      if (aValue < bValue) return sortDirection === 'asc' ? -1 : 1;
      if (aValue > bValue) return sortDirection === 'asc' ? 1 : -1;
      return 0;
    })
    .slice(indexOfFirstItem, indexOfLastItem);

  // Change page function
  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  // Sort function
  const handleSort = (column) => {
    if (sortColumn === column) {
      setSortDirection(sortDirection === 'asc' ? 'desc' : 'asc');
    } else {
      setSortColumn(column);
      setSortDirection('asc');
    }
  };

  // Search function
  const handleSearch = (event) => {
    setSearchQuery(event.target.value);
    setCurrentPage(1); // Reset to the first page when searching
  };

  return (
    <div className="container">
      <h2 className="text-center mb-4">COVID-19 Statistics</h2>
      <div className="row">
        <div className="col-md-12">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Search by country..."
              value={searchQuery}
              onChange={handleSearch}
            />
          </div>
          <table className="table table-striped">
            <thead>
              <tr>
                <th
                  scope="col"
                  onClick={() => handleSort('country')}
                  style={{ cursor: 'pointer' }}
                >
                  Country
                  {sortColumn === 'country' && (
                    <span>{sortDirection === 'asc' ? ' ▲' : ' ▼'}</span>
                  )}
                </th>
                <th
                  scope="col"
                  onClick={() => handleSort('cases')}
                  style={{ cursor: 'pointer' }}
                >
                  Cases
                  {sortColumn === 'cases' && (
                    <span>{sortDirection === 'asc' ? ' ▲' : ' ▼'}</span>
                  )}
                </th>
                <th
                  scope="col"
                  onClick={() => handleSort('deaths')}
                  style={{ cursor: 'pointer' }}
                >
                  Deaths
                  {sortColumn === 'deaths' && (
                    <span>{sortDirection === 'asc' ? ' ▲' : ' ▼'}</span>
                  )}
                </th>
                <th
                  scope="col"
                  onClick={() => handleSort('recovered')}
                  style={{ cursor: 'pointer' }}
                >
                  Recovered
                  {sortColumn === 'recovered' && (
                    <span>{sortDirection === 'asc' ? ' ▲' : ' ▼'}</span>
                  )}
                </th>
                <th
                  scope="col"
                  onClick={() => handleSort('active')}
                  style={{ cursor: 'pointer' }}
                >
                  Active Cases
                  {sortColumn === 'active' && (
                    <span>{sortDirection === 'asc' ? ' ▲' : ' ▼'}</span>
                  )}
                </th>
              </tr>
            </thead>
            <tbody>
              {currentItems.map((country, index) => (
                <tr key={index}>
                  <td>{country.country}</td>
                  <td>{country.cases.toLocaleString()}</td>
                  <td>{country.deaths.toLocaleString()}</td>
                  <td>{country.recovered.toLocaleString()}</td>
                  <td>{country.active.toLocaleString()}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <Pagination
            itemsPerPage={itemsPerPage}
            totalItems={
              countryData.filter((country) =>
                country.country.toLowerCase().includes(searchQuery.toLowerCase())
              ).length
            }
            currentPage={currentPage}
            paginate={paginate}
          />
        </div>
      </div>
    </div>
  );
}

// Pagination component
const Pagination = ({ itemsPerPage, totalItems, currentPage, paginate }) => {
  const pageNumbers = [];

  for (let i = 1; i <= Math.ceil(totalItems / itemsPerPage); i++) {
    pageNumbers.push(i);
  }

  return (
    <nav>
      <ul className="pagination justify-content-center">
        {pageNumbers.map((number) => (
          <li key={number} className={`page-item ${currentPage === number ? 'active' : ''}`}>
            <a onClick={() => paginate(number)} href="#" className="page-link">
              {number}
            </a>
          </li>
        ))}
      </ul>
    </nav>
  );
};

export default TableSection;