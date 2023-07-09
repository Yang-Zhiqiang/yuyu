CREATE TABLE IT_HengakuUnit (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     unitkouryokuhasseiymd                              VARCHAR     (8)                                                                 ,  /* ユニット効力発生日 */
     unitkouryokuendymd                                 VARCHAR     (8)                                                                 ,  /* ユニット効力終了日 */
     unitsuu                                            NUMBER      (13,4)                                                              ,  /* ユニット数 */
     fundhaibunwariai                                   NUMBER      (3)                                                                 ,  /* ファンド配分割合 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_HengakuUnit ADD CONSTRAINT PK_HengakuUnit PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     unitfundkbn                                                /* ユニットファンド区分 */
) ;

CREATE INDEX IX1_HengakuUnit ON IT_HengakuUnit (
     syono                                                    , /* 証券番号 */
     unitfundkbn                                                /* ユニットファンド区分 */
) ;
