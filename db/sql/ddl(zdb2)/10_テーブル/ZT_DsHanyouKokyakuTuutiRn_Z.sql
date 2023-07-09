CREATE TABLE ZT_DsHanyouKokyakuTuutiRn_Z (
     zrndshanyoukokatetuutikey                          CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＤＳ汎用顧客宛通知キー */
     zrndskokno                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）ＤＳ顧客番号 */
     zrndstuutikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＤＳ通知区分 */
     zrnatesakiyno                                      GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）宛先郵便番号 */
     zrnatesakiadr1                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所１ */
     zrnatesakiadr2                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所２ */
     zrnatesakiadr3                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所３ */
     zrnatena1                                          GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）宛名１ */
     zrnatena2                                          GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）宛名２ */
     zrnatesakiynobarcode                               CHAR        (23)                                                      NOT NULL  ,  /* （連携用）宛先郵便番号バーコード */
     zrndai1syoukaifreearea11                           GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿１ */
     zrndai1syoukaifreearea12                           GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿２ */
     zrndai1syoukaifreearea13                           GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿３ */
     zrndai1syoukaifreearea14                           GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿４ */
     zrndai1syoukaifreearea15                           GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１＿５ */
     zrnscdai2syoukaifreearea1                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア１ */
     zrnscdai2syoukaifreearea2                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア２ */
     zrnscdai2syoukaifreearea3                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア３ */
     zrnscdai2syoukaifreearea4                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア４ */
     zrnscdai2syoukaifreearea5                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）ＳＣ第２照会先フリ－エリア５ */
     zrnsakuseimd                                       CHAR        (4)                                                       NOT NULL  ,  /* （連携用）作成月日 */
     zrnsclakadskokno                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）スクランブル化ＤＳ顧客番号 */
     zrnreigaisyorihyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）例外処理表示 */
     zrnsakuseino                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）作成No */
     zrncode                                            CHAR        (3)                                                       NOT NULL  ,  /* （連携用）コード */
     zrntuutimei                                        GRAPHIC     (23)                                                      NOT NULL  ,  /* （連携用）通知名 */
     zrnfreearea11                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１ */
     zrnfreearea12                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２ */
     zrnfreearea13                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿３ */
     zrnfreearea14                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿４ */
     zrnfreearea15                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿５ */
     zrnfreearea16                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿６ */
     zrnfreearea17                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿７ */
     zrnfreearea18                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿８ */
     zrnfreearea19                                      GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿９ */
     zrnfreearea110                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１０ */
     zrnfreearea111                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１１ */
     zrnfreearea112                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１２ */
     zrnfreearea113                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１３ */
     zrnfreearea114                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１４ */
     zrnfreearea115                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１５ */
     zrnfreearea116                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１６ */
     zrnfreearea117                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１７ */
     zrnfreearea118                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１８ */
     zrnfreearea119                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿１９ */
     zrnfreearea120                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２０ */
     zrnfreearea121                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２１ */
     zrnfreearea122                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２２ */
     zrnfreearea123                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２３ */
     zrnfreearea124                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２４ */
     zrnfreearea125                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２５ */
     zrnfreearea126                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２６ */
     zrnfreearea127                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２７ */
     zrnfreearea128                                     GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）フリーエリア１＿２８ */
     zrnfreearea21                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１ */
     zrnfreearea22                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２ */
     zrnfreearea23                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿３ */
     zrnfreearea24                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿４ */
     zrnfreearea25                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿５ */
     zrnfreearea26                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿６ */
     zrnfreearea27                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿７ */
     zrnfreearea28                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿８ */
     zrnfreearea29                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿９ */
     zrnfreearea210                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１０ */
     zrnfreearea211                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１１ */
     zrnfreearea212                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１２ */
     zrnfreearea213                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１３ */
     zrnfreearea214                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１４ */
     zrnfreearea215                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１５ */
     zrnfreearea216                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１６ */
     zrnfreearea217                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１７ */
     zrnfreearea218                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１８ */
     zrnfreearea219                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１９ */
     zrnfreearea220                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２０ */
     zrnfreearea221                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２１ */
     zrnfreearea222                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２２ */
     zrnfreearea223                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２３ */
     zrnfreearea224                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２４ */
     zrnfreearea225                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２５ */
     zrnfreearea226                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２６ */
     zrnfreearea227                                     GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２７ */
     zrnfreearea228                                     GRAPHIC     (37)                                                      NOT NULL     /* （連携用）フリーエリア２＿２８ */
)
;

ALTER TABLE ZT_DsHanyouKokyakuTuutiRn_Z ADD CONSTRAINT PK_DsKokyakuHanyouTuutiRn PRIMARY KEY (
     zrndshanyoukokatetuutikey                                , /* （連携用）ＤＳ汎用顧客宛通知キー */
     zrndskokno                                               , /* （連携用）ＤＳ顧客番号 */
     zrndstuutikbn                                              /* （連携用）ＤＳ通知区分 */
) ;
