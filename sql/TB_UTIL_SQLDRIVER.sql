/*------------------------------------------------------------------------------
-- 개체 이름: ROOT.TB_UTIL_SQLDRIVER
-- 만든 날짜: 2021-06-02 오전 10:54:47
-- 마지막으로 수정한 날짜: 2021-06-02 오전 10:54:47
-- 상태: VALID
------------------------------------------------------------------------------*/
DROP TABLE ROOT.TB_UTIL_SQLDRIVER CASCADE CONSTRAINTS;

CREATE TABLE ROOT.TB_UTIL_SQLDRIVER (
  DATABASEURL    VARCHAR2(500 BYTE)         NULL, 
  DATABASEID     VARCHAR2(50 BYTE)          NULL, 
  DATABASEPW     VARCHAR2(50 BYTE)          NULL
)
TABLESPACE SYSTEM
PCTFREE    10
PCTUSED    40
INITRANS   1
MAXTRANS   255
STORAGE (
    INITIAL     64K
    NEXT        1M
    MINEXTENTS  1
    MAXEXTENTS  UNLIMITED
    FREELISTS   1
    FREELIST GROUPS 1
)
LOGGING
NOCACHE
MONITORING
NOPARALLEL
;


