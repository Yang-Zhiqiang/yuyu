CREATE TABLE HT_Henkin_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     hnkninputrenno                                     VARCHAR     (20)                                                                ,  /* 返金入力連番 */
     hnknsyoriymd                                       VARCHAR     (8)                                                                 ,  /* 返金処理日 */
     hnkngk                                             DECIMAL     (13)                                                                ,  /* 返金額 */
     hnkngk$                                            VARCHAR     (10)                                                                ,  /* 返金額(通貨型) */
     hnkntuukasyu                                       VARCHAR     (3)                                                                 ,  /* 返金通貨種類 */
     pkakinsyoriymd                                     VARCHAR     (8)                                                                 ,  /* Ｐ過金処理日 */
     hnknhoukbn                                         VARCHAR     (2)                                                                 ,  /* 返金方法区分 */
     hnknymd                                            VARCHAR     (8)                                                                 ,  /* 返金日 */
     hnknriyuukbn                                       VARCHAR     (1)                                                                 ,  /* 返金理由区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     srgohnknumu                                        VARCHAR     (1)                                                                 ,  /* 成立後返金有無 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                                 ,  /* 枝番号 */
     pkakindenrenno                                     VARCHAR     (20)                                                                ,  /* Ｐ過金伝票データ連番 */
     pkakindenedano                                     DECIMAL     (2)                                                                 ,  /* Ｐ過金伝票枝番号 */
     fbsoukindatasikibetukey                            VARCHAR     (20)                                                                ,  /* ＦＢ送金データ識別キー */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     henkinsyoritime                                    VARCHAR     (17)                                                                ,  /* 返金処理日時 */
     zenhnknrenno                                       DECIMAL     (2)                                                                    /* 全額返金連番 */
)
;

ALTER TABLE HT_Henkin_Z ADD CONSTRAINT PK_Henkin PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_Henkin ON HT_Henkin_Z (
     hnknsyoriymd                                             , /* 返金処理日 */
     hnkntuukasyu                                               /* 返金通貨種類 */
) ;
