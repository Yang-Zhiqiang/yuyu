CREATE TABLE ZT_DairitenSyougouRn (
     zrndairitencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード */
     zrnkanjihoujinsyougou                              VARCHAR     (40)                                                      NOT NULL  ,  /* （連携用）漢字法人商号 */
     zrnyobiv13                                         CHAR        (13)                                                      NOT NULL     /* （連携用）予備項目Ｖ１３ */
)
;

ALTER TABLE ZT_DairitenSyougouRn ADD CONSTRAINT PK_DairitenSyougouRn PRIMARY KEY (
     zrndairitencd                                              /* （連携用）代理店コード */
) ;
