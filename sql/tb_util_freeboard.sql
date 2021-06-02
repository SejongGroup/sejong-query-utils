/*------------------------------------------------------------------------------
-- ��ü �̸�: ROOT.TB_UTIL_FREEBOARD
-- ���� ��¥: 2021-05-28 ���� 10:16:22
-- ���������� ������ ��¥: 2021-05-28 ���� 10:23:31
-- ����: VALID
------------------------------------------------------------------------------*/
DROP TABLE ROOT.TB_UTIL_FREEBOARD CASCADE CONSTRAINTS;

CREATE TABLE ROOT.TB_UTIL_FREEBOARD (
  BNO          NUMBER                  NOT NULL, 
  TITLE        VARCHAR2(200 BYTE)      NOT NULL, 
  CONTENT      VARCHAR2(4000 BYTE)         NULL, 
  WRITER       VARCHAR2(50 BYTE)       NOT NULL, 
  REGDATE      DATE                   DEFAULT sysdate                        NULL, 
  VIEWCOUNT    NUMBER                 DEFAULT 0                      NULL
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

ALTER TABLE ROOT.TB_UTIL_FREEBOARD ADD
(
    CONSTRAINT TB_UTIL_FREEBOARD_PK
    PRIMARY KEY ( BNO )
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


