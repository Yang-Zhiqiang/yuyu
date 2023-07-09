CREATE TABLE IT_DSeisanShrTysySyusei (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     seisandshrymd                                      VARCHAR     (8)                                                                 ,  /* 精算Ｄ支払年月日 */
     seisand                                            NUMBER      (13)                                                                ,  /* 精算Ｄ */
     seisand$                                           VARCHAR     (10)                                                                ,  /* 精算Ｄ(通貨型) */
     tyouseid                                           NUMBER      (13)                                                                ,  /* 調整Ｄ */
     tyouseid$                                          VARCHAR     (10)                                                                ,  /* 調整Ｄ(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_DSeisanShrTysySyusei ADD CONSTRAINT PK_DSeisanShrTysySyusei PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     syoriYmd                                                   /* 処理年月日 */
) ;

CREATE INDEX IX1_DSeisanShrTysySyusei ON IT_DSeisanShrTysySyusei (
     syoriYmd                                                   /* 処理年月日 */
) ;
