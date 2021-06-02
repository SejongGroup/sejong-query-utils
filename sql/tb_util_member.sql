/*------------------------------------------------------------------------------
-- 개체 이름: ROOT.TB_UTIL_MEMBER
-- 만든 날짜: 2021-05-28 오전 10:17:01
-- 마지막으로 수정한 날짜: 2021-05-28 오전 10:17:01
-- 상태: VALID
------------------------------------------------------------------------------*/
DROP TABLE ROOT.TB_UTIL_MEMBER CASCADE CONSTRAINTS;

CREATE TABLE ROOT.TB_UTIL_MEMBER (
  USERID         VARCHAR2(20 BYTE)     NOT NULL, 
  USERPW         VARCHAR2(20 BYTE)     NOT NULL, 
  USEREMAIL      VARCHAR2(50 BYTE)     NOT NULL, 
  PHONENUMBER    VARCHAR2(20 BYTE)     NOT NULL
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

ALTER TABLE ROOT.TB_UTIL_MEMBER ADD
(
    CONSTRAINT TB_UTIL_MEMBER_PK
    PRIMARY KEY ( USERID )
        USING INDEX
        TABLESPACE SYSTEM 
        PCTFREE 10
        INITRANS 2
        MAXTRANS 255
        STORAGE (
            INITIAL 64K
            NEXT 1M
            MINEXTENTS 1
            MAXEXTENTS UNLIMITED
            FREELISTS 1
            FREELIST GROUPS 1
        )
);


