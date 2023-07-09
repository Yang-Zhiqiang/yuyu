CREATE TABLE IT_HokenryouTmttkn_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tmttkntaisyouym                                    VARCHAR     (6)                                                       NOT NULL  ,  /* 積立金対象年月 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     ptmttkngk                                          DECIMAL     (13)                                                                ,  /* 保険料積立金額 */
     ptmttkngk$                                         VARCHAR     (10)                                                                ,  /* 保険料積立金額(通貨型) */
     kihrkmpstgk                                        DECIMAL     (13)                                                                ,  /* 既払込保険料相当額 */
     kihrkmpstgk$                                       VARCHAR     (10)                                                                ,  /* 既払込保険料相当額(通貨型) */
     tyouseimaeptmttkngk                                DECIMAL     (13)                                                                ,  /* 調整前保険料積立金額 */
     tyouseimaeptmttkngk$                               VARCHAR     (10)                                                                ,  /* 調整前保険料積立金額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_HokenryouTmttkn_Z ADD CONSTRAINT PK_HokenryouTmttkn PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tmttkntaisyouym                                          , /* 積立金対象年月 */
     renno                                                      /* 連番 */
) ;
