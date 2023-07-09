CREATE TABLE ZT_DsHanyouKokyakuTuutiTy (
     ztydshanyoukokatetuutikey                          VARCHAR     (15)                                                      NOT NULL  ,  /* （中継用）ＤＳ汎用顧客宛通知キー */
     ztydskokno                                         VARCHAR     (10)                                                      NOT NULL  ,  /* （中継用）ＤＳ顧客番号 */
     ztydstuutikbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）ＤＳ通知区分 */
     ztyatesakiyno                                      VARCHAR     (8)                                                                 ,  /* （中継用）宛先郵便番号 */
     ztyatesakiadr1                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所１ */
     ztyatesakiadr2                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所２ */
     ztyatesakiadr3                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所３ */
     ztyatena1                                          VARCHAR     (19)                                                                ,  /* （中継用）宛名１ */
     ztyatena2                                          VARCHAR     (19)                                                                ,  /* （中継用）宛名２ */
     ztyatesakiynobarcode                               VARCHAR     (23)                                                                ,  /* （中継用）宛先郵便番号バーコード */
     ztydai1syoukaifreearea11                           VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１＿１ */
     ztydai1syoukaifreearea12                           VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１＿２ */
     ztydai1syoukaifreearea13                           VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１＿３ */
     ztydai1syoukaifreearea14                           VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１＿４ */
     ztydai1syoukaifreearea15                           VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１＿５ */
     ztyscdai2syoukaifreearea1                          VARCHAR     (20)                                                                ,  /* （中継用）ＳＣ第２照会先フリ－エリア１ */
     ztyscdai2syoukaifreearea2                          VARCHAR     (20)                                                                ,  /* （中継用）ＳＣ第２照会先フリ－エリア２ */
     ztyscdai2syoukaifreearea3                          VARCHAR     (20)                                                                ,  /* （中継用）ＳＣ第２照会先フリ－エリア３ */
     ztyscdai2syoukaifreearea4                          VARCHAR     (20)                                                                ,  /* （中継用）ＳＣ第２照会先フリ－エリア４ */
     ztyscdai2syoukaifreearea5                          VARCHAR     (20)                                                                ,  /* （中継用）ＳＣ第２照会先フリ－エリア５ */
     ztysakuseimd                                       VARCHAR     (4)                                                                 ,  /* （中継用）作成月日 */
     ztysclakadskokno                                   VARCHAR     (10)                                                                ,  /* （中継用）スクランブル化ＤＳ顧客番号 */
     ztyreigaisyorihyj                                  VARCHAR     (1)                                                                 ,  /* （中継用）例外処理表示 */
     ztysakuseino                                       VARCHAR     (7)                                                                 ,  /* （中継用）作成No */
     ztycode                                            VARCHAR     (3)                                                                 ,  /* （中継用）コード */
     ztytuutimei                                        VARCHAR     (23)                                                                ,  /* （中継用）通知名 */
     ztyfreearea11                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１ */
     ztyfreearea12                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２ */
     ztyfreearea13                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿３ */
     ztyfreearea14                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿４ */
     ztyfreearea15                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿５ */
     ztyfreearea16                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿６ */
     ztyfreearea17                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿７ */
     ztyfreearea18                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿８ */
     ztyfreearea19                                      VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿９ */
     ztyfreearea110                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１０ */
     ztyfreearea111                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１１ */
     ztyfreearea112                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１２ */
     ztyfreearea113                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１３ */
     ztyfreearea114                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１４ */
     ztyfreearea115                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１５ */
     ztyfreearea116                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１６ */
     ztyfreearea117                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１７ */
     ztyfreearea118                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１８ */
     ztyfreearea119                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿１９ */
     ztyfreearea120                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２０ */
     ztyfreearea121                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２１ */
     ztyfreearea122                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２２ */
     ztyfreearea123                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２３ */
     ztyfreearea124                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２４ */
     ztyfreearea125                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２５ */
     ztyfreearea126                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２６ */
     ztyfreearea127                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２７ */
     ztyfreearea128                                     VARCHAR     (31)                                                                ,  /* （中継用）フリーエリア１＿２８ */
     ztyfreearea21                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１ */
     ztyfreearea22                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２ */
     ztyfreearea23                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿３ */
     ztyfreearea24                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿４ */
     ztyfreearea25                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿５ */
     ztyfreearea26                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿６ */
     ztyfreearea27                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿７ */
     ztyfreearea28                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿８ */
     ztyfreearea29                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿９ */
     ztyfreearea210                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１０ */
     ztyfreearea211                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１１ */
     ztyfreearea212                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１２ */
     ztyfreearea213                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１３ */
     ztyfreearea214                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１４ */
     ztyfreearea215                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１５ */
     ztyfreearea216                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１６ */
     ztyfreearea217                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１７ */
     ztyfreearea218                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１８ */
     ztyfreearea219                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１９ */
     ztyfreearea220                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２０ */
     ztyfreearea221                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２１ */
     ztyfreearea222                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２２ */
     ztyfreearea223                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２３ */
     ztyfreearea224                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２４ */
     ztyfreearea225                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２５ */
     ztyfreearea226                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２６ */
     ztyfreearea227                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２７ */
     ztyfreearea228                                     VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２８ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_DsHanyouKokyakuTuutiTy ADD CONSTRAINT PK_DsKokyakuHanyouTuutiTy PRIMARY KEY (
     ztydshanyoukokatetuutikey                                , /* （中継用）ＤＳ汎用顧客宛通知キー */
     ztydskokno                                               , /* （中継用）ＤＳ顧客番号 */
     ztydstuutikbn                                              /* （中継用）ＤＳ通知区分 */
) ;
