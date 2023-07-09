CREATE TABLE JW_HubiWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     renrakusakinmkj                                    VARCHAR     (15)                                                                ,  /* 連絡先氏名（漢字） */
     renrakuyno                                         VARCHAR     (7)                                                                 ,  /* 連絡先郵便番号 */
     renrakusakiadr1kj                                  VARCHAR     (30)                                                                ,  /* 連絡先住所１（漢字） */
     renrakusakiadr2kj                                  VARCHAR     (30)                                                                ,  /* 連絡先住所２（漢字） */
     renrakusakiadr3kj                                  VARCHAR     (30)                                                                ,  /* 連絡先住所３（漢字） */
     renrakusakitelno                                   VARCHAR     (14)                                                                ,  /* 連絡先電話番号 */
     renrakuarea                                        VARCHAR     (418)                                                               ,  /* 連絡欄 */
     sisyacd                                            VARCHAR     (3)                                                                 ,  /* 支社コード */
     sisyanm                                            VARCHAR     (20)                                                                ,  /* 支社名 */
     toiawasesosikinmkj                                 VARCHAR     (15)                                                                ,  /* 問合せ先組織名（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JW_HubiWk ADD CONSTRAINT PK_HubiWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
