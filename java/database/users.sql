-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER rc_owner
WITH PASSWORD 'rc_app';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO rc_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO rc_owner;

CREATE USER rc_appuser
WITH PASSWORD 'rc_app';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO rc_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO rc_appuser;
