CREATE TABLE ZT_DsHanyouKokyakuTuutiRn (
     zrndshanyoukokatetuutikey                          CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＤＳ汎用顧客宛通知キー */
     zrndskokno                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）ＤＳ顧客番号 */
     zrndstuutikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＤＳ通知区分 */
     zrnatesakiyno                                      VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）宛先郵便番号 */
     zrnatesakiadr1                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所１ */
     zrnatesakiadr2                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所２ */
     zrnatesakiadr3                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所３ */
     zrnatena1                                          VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）宛名１ */
     zrnatena2                                          VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）宛名２ */
     zrnatesakiynobarcode                               CHAR        (23)                                                      NOT NULL  ,  /* （連携用）宛先郵便番号バーコード */
     zrndai1syoukaifreearea11                           VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿１ */
     zrndai1syoukaifreearea12                           VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿２ */
     zrndai1syoukaifreearea13                           VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿３ */
     zrndai1syoukaifreearea14                           VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿４ */
     zrndai1syoukaifreearea15                           VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿５ */
     zrnscdai2syoukaifreearea1                          VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア１ */
     zrnscdai2syoukaifreearea2                          VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア２ */
     zrnscdai2syoukaifreearea3                          VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア３ */
     zrnscdai2syoukaifreearea4                          VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア４ */
     zrnscdai2syoukaifreearea5                          VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア５ */
     zrnsakuseimd                                       CHAR        (4)                                                       NOT NULL  ,  /* （連携用）作成月日 */
     zrnsclakadskokno                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）スクランブル化ＤＳ顧客番号 */
     zrnreigaisyorihyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）例外処理表示 */
     zrnsakuseino                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）作成No */
     zrncode                                            CHAR        (3)                                                       NOT NULL  ,  /* （連携用）コード */
     zrntuutimei                                        VARCHAR     (23)                                                      NOT NULL  ,  /* （連携用）通知名 */
     zrnfreearea11                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１ */
     zrnfreearea12                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２ */
     zrnfreearea13                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿３ */
     zrnfreearea14                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿４ */
     zrnfreearea15                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿５ */
     zrnfreearea16                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿６ */
     zrnfreearea17                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿７ */
     zrnfreearea18                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿８ */
     zrnfreearea19                                      VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿９ */
     zrnfreearea110                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１０ */
     zrnfreearea111                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１１ */
     zrnfreearea112                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１２ */
     zrnfreearea113                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１３ */
     zrnfreearea114                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１４ */
     zrnfreearea115                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１５ */
     zrnfreearea116                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１６ */
     zrnfreearea117                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１７ */
     zrnfreearea118                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１８ */
     zrnfreearea119                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１９ */
     zrnfreearea120                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２０ */
     zrnfreearea121                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２１ */
     zrnfreearea122                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２２ */
     zrnfreearea123                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２３ */
     zrnfreearea124                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２４ */
     zrnfreearea125                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２５ */
     zrnfreearea126                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２６ */
     zrnfreearea127                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２７ */
     zrnfreearea128                                     VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２８ */
     zrnfreearea21                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１ */
     zrnfreearea22                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２ */
     zrnfreearea23                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿３ */
     zrnfreearea24                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿４ */
     zrnfreearea25                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿５ */
     zrnfreearea26                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿６ */
     zrnfreearea27                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿７ */
     zrnfreearea28                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿８ */
     zrnfreearea29                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿９ */
     zrnfreearea210                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１０ */
     zrnfreearea211                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１１ */
     zrnfreearea212                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１２ */
     zrnfreearea213                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１３ */
     zrnfreearea214                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１４ */
     zrnfreearea215                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１５ */
     zrnfreearea216                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１６ */
     zrnfreearea217                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１７ */
     zrnfreearea218                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１８ */
     zrnfreearea219                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１９ */
     zrnfreearea220                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２０ */
     zrnfreearea221                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２１ */
     zrnfreearea222                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２２ */
     zrnfreearea223                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２３ */
     zrnfreearea224                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２４ */
     zrnfreearea225                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２５ */
     zrnfreearea226                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２６ */
     zrnfreearea227                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２７ */
     zrnfreearea228                                     VARCHAR     (37)                                                      NOT NULL     /* （連携用）フリーエリア２＿２８ */
)
;

ALTER TABLE ZT_DsHanyouKokyakuTuutiRn ADD CONSTRAINT PK_DsKokyakuHanyouTuutiRn PRIMARY KEY (
     zrndshanyoukokatetuutikey                                , /* （連携用）ＤＳ汎用顧客宛通知キー */
     zrndskokno                                               , /* （連携用）ＤＳ顧客番号 */
     zrndstuutikbn                                              /* （連携用）ＤＳ通知区分 */
) ;
