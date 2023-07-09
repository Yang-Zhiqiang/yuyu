CREATE TABLE ZT_DsKariPasswordTuutiTy (
     ztykrpasswordtuutikey                              VARCHAR     (15)                                                      NOT NULL  ,  /* （中継用）仮パスワード通知キー                               */
     ztydskokno                                         VARCHAR     (10)                                                                ,  /* （中継用）ＤＳ顧客番号                                   */
     ztyatesakiyno                                      VARCHAR     (8)                                                                 ,  /* （中継用）宛先郵便番号                                   */
     ztyatesakiynobarcode                               VARCHAR     (23)                                                                ,  /* （中継用）宛先郵便番号バーコード                              */
     ztysakuseimd                                       VARCHAR     (4)                                                                 ,  /* （中継用）作成月日                                     */
     ztysclakadskokno                                   VARCHAR     (10)                                                                ,  /* （中継用）スクランブル化ＤＳ顧客番号                            */
     ztyreigaisyorihyj                                  VARCHAR     (1)                                                                 ,  /* （中継用）例外処理表示                                   */
     ztyyuubinbutukanpusakiyno                          VARCHAR     (8)                                                                 ,  /* （中継用）郵便物還付先郵便番号                               */
     ztyyuubinbutukanpusakiadr                          VARCHAR     (15)                                                                ,  /* （中継用）郵便物還付先住所                                 */
     ztyatesakiadr1                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所１                                    */
     ztyatesakiadr2                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所２                                    */
     ztyatesakiadr3                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所３                                    */
     ztyatena1                                          VARCHAR     (19)                                                                ,  /* （中継用）宛名１                                      */
     ztyatena2                                          VARCHAR     (19)                                                                ,  /* （中継用）宛名２                                      */
     ztydai1syoukaisakifreearea1                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１                             */
     ztydai1syoukaisakifreearea2                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア２                             */
     ztydai1syoukaisakifreearea3                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア３                             */
     ztydai1syoukaisakifreearea4                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア４                             */
     ztydai1syoukaisakifreearea5                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア５                             */
     ztysakuseino                                       VARCHAR     (7)                                                                 ,  /* （中継用）作成No                                     */
     ztyokyakusamanm                                    VARCHAR     (17)                                                                ,  /* （中継用）お客様氏名                                    */
     ztyhkymd                                           VARCHAR     (11)                                                                ,  /* （中継用）発行日                                      */
     ztydskrhnnkakcdyoken                               VARCHAR     (4)                                                                 ,  /* （中継用）ＤＳ仮本人確認コード与件                             */
     ztykrpasswordyuukouymd                             VARCHAR     (11)                                                                ,  /* （中継用）仮パスワード有効年月日                              */
     ztyfreearea1                                       VARCHAR     (35)                                                                ,  /* （中継用）フリーエリア１                                  */
     ztyfreearea2                                       VARCHAR     (35)                                                                ,  /* （中継用）フリーエリア２                                  */
     ztyfreearea3                                       VARCHAR     (35)                                                                ,  /* （中継用）フリーエリア３                                  */
     ztyfreearea4                                       VARCHAR     (35)                                                                ,  /* （中継用）フリーエリア４                                  */
     ztyfreearea5                                       VARCHAR     (35)                                                                ,  /* （中継用）フリーエリア５                                  */
     ztytyuuijikou1                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄１                                   */
     ztytyuuijikou2                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄２                                   */
     ztytyuuijikou3                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄３                                   */
     ztytyuuijikou4                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄４                                   */
     ztytyuuijikou5                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄５                                   */
     ztytyuuijikou6                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄６                                   */
     ztytyuuijikou7                                     VARCHAR     (35)                                                                ,  /* （中継用）注意事項欄７                                   */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE ZT_DsKariPasswordTuutiTy ADD CONSTRAINT PK_DsKariPasswordTuutiTy PRIMARY KEY (
     ztykrpasswordtuutikey                                      /* （中継用）仮パスワード通知キー                                */
) ;
