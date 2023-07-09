CREATE TABLE AT_TyouhyouKensaku (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     reportKey                                          VARCHAR     (20)                                                                ,  /* 帳票キー */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     categoryId                                         VARCHAR     (50)                                                                ,  /* カテゴリＩＤ */
     kinouId                                            VARCHAR     (50)                                                                ,  /* 機能ＩＤ */
     kensakuKey1                                        VARCHAR     (30)                                                                ,  /* 検索キー１ */
     kensakuKey2                                        VARCHAR     (30)                                                                ,  /* 検索キー２ */
     kensakuKey3                                        VARCHAR     (30)                                                                ,  /* 検索キー３ */
     kensakuKey4                                        VARCHAR     (30)                                                                ,  /* 検索キー４ */
     kensakuKey5                                        VARCHAR     (30)                                                                ,  /* 検索キー５ */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     firstOutYmd                                        VARCHAR     (8)                                                                 ,  /* 初回出力年月日 */
     lastOutYmd                                         VARCHAR     (8)                                                                 ,  /* 最終出力年月日 */
     outCount                                           NUMBER      (3)                                                                 ,  /* 出力回数 */
     lastOutUserId                                      VARCHAR     (30)                                                                ,  /* 最終出力ユーザーＩＤ */
     syoruiKetugouUmuKbn                                VARCHAR     (1)                                                                 ,  /* 書類結合有無区分 */
     fileSize                                           NUMBER      (12)                                                                ,  /* ファイルサイズ */
     pageCount                                          NUMBER      (5)                                                                 ,  /* ページ数 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AT_TyouhyouKensaku ADD CONSTRAINT AT_TyouhyouKensakuPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx1 ON AT_TyouhyouKensaku (
     reportKey                                                  /* 帳票キー */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx2 ON AT_TyouhyouKensaku (
     syoruiCd                                                 , /* 書類コード */
     syoriYmd                                                   /* 処理年月日 */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx3 ON AT_TyouhyouKensaku (
     kensakuKey1                                                /* 検索キー１ */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx4 ON AT_TyouhyouKensaku (
     kensakuKey2                                                /* 検索キー２ */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx5 ON AT_TyouhyouKensaku (
     kensakuKey3                                                /* 検索キー３ */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx6 ON AT_TyouhyouKensaku (
     kensakuKey4                                                /* 検索キー４ */
) ;

CREATE INDEX AT_TyouhyouKensakuIdx7 ON AT_TyouhyouKensaku (
     kensakuKey5                                                /* 検索キー５ */
) ;
