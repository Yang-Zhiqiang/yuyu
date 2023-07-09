CREATE TABLE ZT_DsKariPasswordTuutiRn_Z (
     zrnkrpasswordtuutikey                              CHAR        (15)                                                      NOT NULL  ,  /* （連携用）仮パスワード通知キー */
     zrndskokno                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）ＤＳ顧客番号 */
     zrnatesakiyno                                      GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）宛先郵便番号 */
     zrnatesakiynobarcode                               CHAR        (23)                                                      NOT NULL  ,  /* （連携用）宛先郵便番号バーコード */
     zrnsakuseimd                                       CHAR        (4)                                                       NOT NULL  ,  /* （連携用）作成月日 */
     zrnsclakadskokno                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）スクランブル化ＤＳ顧客番号 */
     zrnreigaisyorihyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）例外処理表示 */
     zrnyuubinbutukanpusakiyno                          GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）郵便物還付先郵便番号 */
     zrnyuubinbutukanpusakiadr                          GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）郵便物還付先住所 */
     zrnatesakiadr1                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所１ */
     zrnatesakiadr2                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所２ */
     zrnatesakiadr3                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所３ */
     zrnatena1                                          GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）宛名１ */
     zrnatena2                                          GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）宛名２ */
     zrndai1syoukaisakifreearea1                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１ */
     zrndai1syoukaisakifreearea2                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア２ */
     zrndai1syoukaisakifreearea3                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア３ */
     zrndai1syoukaisakifreearea4                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア４ */
     zrndai1syoukaisakifreearea5                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア５ */
     zrnsakuseino                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）作成No */
     zrnokyakusamanm                                    GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）お客様氏名 */
     zrnhkymd                                           GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）発行日 */
     zrndskrhnnkakcdyoken                               CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＤＳ仮本人確認コード与件 */
     zrnkrpasswordyuukouymd                             GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）仮パスワード有効年月日 */
     zrnfreearea1                                       GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）フリーエリア１ */
     zrnfreearea2                                       GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）フリーエリア２ */
     zrnfreearea3                                       GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）フリーエリア３ */
     zrnfreearea4                                       GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）フリーエリア４ */
     zrnfreearea5                                       GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）フリーエリア５ */
     zrntyuuijikou1                                     GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）注意事項欄１ */
     zrntyuuijikou2                                     GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）注意事項欄２ */
     zrntyuuijikou3                                     GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）注意事項欄３ */
     zrntyuuijikou4                                     GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）注意事項欄４ */
     zrntyuuijikou5                                     GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）注意事項欄５ */
     zrntyuuijikou6                                     GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）注意事項欄６ */
     zrntyuuijikou7                                     GRAPHIC     (35)                                                      NOT NULL     /* （連携用）注意事項欄７ */
)
;

ALTER TABLE ZT_DsKariPasswordTuutiRn_Z ADD CONSTRAINT PK_DsKariPasswordTuutiRn PRIMARY KEY (
     zrnkrpasswordtuutikey                                      /* （連携用）仮パスワード通知キー */
) ;
