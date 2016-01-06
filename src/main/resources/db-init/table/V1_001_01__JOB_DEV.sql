CREATE TABLE "JOB_DEV"
(
  "JOB_ID"          VARCHAR2(40 BYTE),
  "JOB_NAME"        VARCHAR2(50 BYTE),
  "JOB_GROUP"       VARCHAR2(50 BYTE),
  "TARGET_OBJECT"   VARCHAR2(100 BYTE),
  "TARGET_METHOD"   VARCHAR2(50 BYTE),
  "JOB_STATUS"      CHAR(1 BYTE),
  "CORN_EXPRESSION" VARCHAR2(50 BYTE)
);