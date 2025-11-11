# CABA-Pro REST API Documentation

## Overview

The CABA-Pro REST API provides programmatic access to the basketball referee management system. All endpoints return JSON data and are documented with OpenAPI/Swagger.

## Base URL

```
http://localhost:8080/api
```

## Interactive Documentation

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## Authentication

Currently, all API endpoints are publicly accessible. JWT authentication is planned for future releases.

---

## API Endpoints

### 📊 Statistics

#### Get System Statistics
```http
GET /api/statistics
```

Returns comprehensive system statistics including referee counts, tournament counts, match states, and assignment states.

**Response:**
```json
{
  "totalReferees": 25,
  "totalTournaments": 5,
  "totalCourts": 8,
  "matchesProgrammed": 12,
  "assignmentsPending": 5,
  "assignmentsAccepted": 15,
  "assignmentsRejected": 2,
  "assignmentsCompleted": 30
}
```

---

### 👥 Referees

#### Get All Referees
```http
GET /api/referees
```

Returns a list of all referees (summary format).

#### Get Referee by ID
```http
GET /api/referees/{id}
```

Returns detailed information about a specific referee.

#### Get Active Referees
```http
GET /api/referees/active
```

Returns only active referees.

#### Get Referees by Rank
```http
GET /api/referees/rank/{rank}
```

Filter referees by rank: `NATIONAL`, `STATE`, `MUNICIPAL`, `LOCAL`

#### Get Referees by Specialty
```http
GET /api/referees/specialty/{specialty}
```

Filter referees by specialty: `FEMININE`, `MASCULINE`, `BOTH`

#### Get Top Referees
```http
GET /api/referees/top?limit=10
```

Returns top-rated referees by average score.

---

### 🏆 Tournaments

#### Get All Tournaments
```http
GET /api/tournaments
```

Returns a list of all tournaments (summary format).

#### Get Tournament by ID
```http
GET /api/tournaments/{id}
```

Returns detailed information about a specific tournament.

#### Get Active Tournaments
```http
GET /api/tournaments/active
```

Returns only active tournaments.

#### Get Current Tournaments
```http
GET /api/tournaments/current
```

Returns tournaments currently in progress.

---

### 🏀 Matches

#### Get All Matches
```http
GET /api/matches
```

Returns a list of all matches (summary format).

#### Get Match by ID
```http
GET /api/matches/{id}
```

Returns detailed information about a specific match including assignments.

#### Get Upcoming Matches
```http
GET /api/matches/upcoming
```

Returns matches scheduled from today onwards.

#### Get Matches by Date Range
```http
GET /api/matches/range?startDate=2025-01-01&endDate=2025-12-31
```

Returns matches within a specified date range.

**Query Parameters:**
- `startDate` (required): Start date in `yyyy-MM-dd` format
- `endDate` (required): End date in `yyyy-MM-dd` format

#### Get Matches by Referee
```http
GET /api/matches/referee/{refereeId}
```

Returns matches assigned to a specific referee.

#### Get Matches by Tournament
```http
GET /api/matches/tournament/{tournamentId}
```

Returns matches for a specific tournament.

---

### 🏟️ Courts

#### Get All Courts
```http
GET /api/courts
```

Returns a list of all courts.

#### Get Court by ID
```http
GET /api/courts/{id}
```

Returns detailed information about a specific court.

#### Get Active Courts
```http
GET /api/courts/active
```

Returns only active courts.

#### Get Courts by City
```http
GET /api/courts/city/{city}
```

Returns courts filtered by city name.

---

## Response Formats

### RefereeSummaryDto
```json
{
  "id": 1,
  "fullName": "Juan Pérez",
  "rank": "NATIONAL",
  "specialty": "BOTH"
}
```

### RefereeDetailDto
```json
{
  "id": 1,
  "firstName": "Juan",
  "lastName": "Pérez",
  "document": "12345678",
  "email": "juan@example.com",
  "phone": "+57 123456789",
  "rank": "NATIONAL",
  "specialty": "BOTH",
  "photoUrl": "/uploads/photos/uuid-filename.jpg"
}
```

### TournamentDto
```json
{
  "id": 1,
  "name": "Liga Nacional 2025",
  "description": "Torneo nacional de baloncesto",
  "startDate": "2025-01-15",
  "endDate": "2025-06-30",
  "state": "IN_PROGRESS",
  "active": true
}
```

### MatchDto
```json
{
  "id": 1,
  "localTeam": "Equipo A",
  "visitorTeam": "Equipo B",
  "dateHour": "2025-11-15T18:00:00",
  "state": "PROGRAMMED",
  "localResult": null,
  "visitorResult": null,
  "observations": null,
  "tournament": {
    "id": 1,
    "name": "Liga Nacional 2025",
    "startDate": "2025-01-15",
    "endDate": "2025-06-30",
    "state": "IN_PROGRESS"
  },
  "court": {
    "id": 1,
    "name": "Coliseo Central",
    "address": "Calle 123 #45-67",
    "city": "Bogotá",
    "phone": "+57 123456789",
    "active": true
  },
  "assignments": [
    {
      "id": 1,
      "referee": {
        "id": 1,
        "fullName": "Juan Pérez",
        "rank": "NATIONAL",
        "specialty": "BOTH"
      },
      "refereeRole": "FIRST_REFEREE",
      "state": "ACCEPTED",
      "responseDate": "2025-11-10T10:30:00",
      "comments": null
    }
  ]
}
```

---

## Enums

### Referee.Rank
- `NATIONAL` - National level referee
- `STATE` - State level referee
- `MUNICIPAL` - Municipal level referee
- `LOCAL` - Local level referee

### Referee.Specialty
- `FEMININE` - Female basketball
- `MASCULINE` - Male basketball
- `BOTH` - Both categories

### Match.MatchState
- `PROGRAMMED` - Match scheduled
- `IN_PROGRESS` - Match currently playing
- `FINISHED` - Match completed
- `CANCELED` - Match canceled

### MatchAssignment.RefereeRole
- `FIRST_REFEREE` - Primary referee
- `SECOND_REFEREE` - Secondary referee
- `THIRD_REFEREE` - Third referee
- `ANNOTATOR` - Scorekeeper
- `TIMEKEEPER` - Timer operator
- `OPERATOR_24` - 24-second clock operator

### MatchAssignment.AssignmentState
- `PENDING` - Awaiting referee response
- `ACCEPTED` - Referee accepted assignment
- `REJECTED` - Referee declined assignment
- `COMPLETED` - Assignment completed

### Tournament.TournamentState
- `PROGRAMMED` - Tournament scheduled
- `IN_PROGRESS` - Tournament ongoing
- `FINISHED` - Tournament completed
- `CANCELED` - Tournament canceled

---

## Error Responses

### 404 Not Found
```json
{
  "timestamp": "2025-11-10T15:30:00",
  "status": 404,
  "error": "Not Found",
  "path": "/api/referees/999"
}
```

---

## Usage Examples

### Using cURL

```bash
# Get all referees
curl -X GET http://localhost:8080/api/referees

# Get referee by ID
curl -X GET http://localhost:8080/api/referees/1

# Get upcoming matches
curl -X GET http://localhost:8080/api/matches/upcoming

# Get system statistics
curl -X GET http://localhost:8080/api/statistics
```

### Using JavaScript (Fetch API)

```javascript
// Get all active tournaments
fetch('http://localhost:8080/api/tournaments/active')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));

// Get matches by date range
const startDate = '2025-11-01';
const endDate = '2025-11-30';
fetch(`http://localhost:8080/api/matches/range?startDate=${startDate}&endDate=${endDate}`)
  .then(response => response.json())
  .then(data => console.log(data));
```

---

## Development Notes

- All timestamps are in ISO 8601 format
- Date parameters should be in `yyyy-MM-dd` format
- All endpoints support CORS for development
- Response pagination is not yet implemented (planned for v2)
- JWT authentication is planned for production deployment
