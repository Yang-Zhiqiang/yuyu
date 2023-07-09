CREATE TABLE ZT_OnlineGknyknmeisaiRn_Z (
     zrndatakbn1                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分１  */
     zrnsyubetucd                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）種別コード */
     zrncdkbn                                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）コード区分 */
     zrnsakuseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）作成日 */
     zrnrenrakuymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）連絡日 */
     zrnrenrakukaisuu                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）連絡回数 */
     zrnknjyymdfrom                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）勘定日（自） */
     zrnknjyymdto                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）勘定日（至） */
     zrnbankcd                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）銀行番号 */
     zrnbanknmej                                        CHAR        (15)                                                      NOT NULL  ,  /* （連携用）銀行名（英字） */
     zrnsitencdtori                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支店コード（取次） */
     zrnsitennmejtori                                   CHAR        (15)                                                      NOT NULL  ,  /* （連携用）支店名（英字）（取次） */
     zrnshitencd                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支店番号 */
     zrnsitennmej                                       CHAR        (15)                                                      NOT NULL  ,  /* （連携用）支店名（英字） */
     zrnyokinkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）預金種目区分 */
     zrnkouzano                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）口座番号 */
     zrnkznmej                                          CHAR        (40)                                                      NOT NULL  ,  /* （連携用）口座名（英字） */
     zrnzndktuukasyu                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）残高通貨種類 */
     zrnzndkssketa                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）残高小数桁 */
     zrngktrhkmaezndk                                   CHAR        (15)                                                      NOT NULL  ,  /* （連携用）外貨取引前残高 */
     zrnkasikosikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）貸越区分 */
     zrnyobiv86                                         CHAR        (86)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ８６ */
     zrndatakbn2                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分２ */
     zrndtrecordkbn1                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データレコード区分１ */
     zrndtrecordkousei                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データレコード構成 */
     zrnsyorino1                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理通番１ */
     zrnknjyymd                                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）勘定日 */
     zrnksnymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）起算日 */
     zrniribaraikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入払区分 */
     zrntrhkkbn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）取引区分 */
     zrntrhktuukasyu                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）取引通貨種類 */
     zrntrhkssketa                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）取引小数桁 */
     zrngktrhkgk                                        CHAR        (15)                                                      NOT NULL  ,  /* （連携用）外貨取引金額 */
     zrnbanksyoukaino                                   CHAR        (16)                                                      NOT NULL  ,  /* （連携用）銀行照会番号 */
     zrntrhksyoukaino                                   CHAR        (32)                                                      NOT NULL  ,  /* （連携用）取引先照会番号 */
     zrntekiyounaiyouej                                 CHAR        (48)                                                      NOT NULL  ,  /* （連携用）摘要内容（英字） */
     zrnyobiv103                                        CHAR        (103)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１０３ */
     zrndatakbn3                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分３ */
     zrndtrecordkbn2                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データレコード区分２ */
     zrndtkouseikbn                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データ構成区分 */
     zrntrkscd                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）取消コード */
     zrnsyorino2                                        CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理通番２ */
     zrnbanksyoukaino2                                  CHAR        (16)                                                      NOT NULL  ,  /* （連携用）銀行照会番号２ */
     zrnsimukeymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）仕向日 */
     zrnsetujyuymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）接受日 */
     zrnsoukinsyu                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）送金種類区分 */
     zrnvalueymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）バリュー日 */
     zrnskntuukasyu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）送金通貨種類 */
     zrnsknssketa                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）送金小数桁 */
     zrngksoukingk                                      CHAR        (15)                                                      NOT NULL  ,  /* （連携用）外貨送金額 */
     zrnirninnm                                         CHAR        (140)                                                     NOT NULL  ,  /* （連携用）依頼人名 */
     zrnyobiv40                                         CHAR        (40)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４０ */
     zrndatakbn4                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分４ */
     zrndtrecordkbn3                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データレコード区分３ */
     zrndourecordsuu1                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）同種レコード数１ */
     zrndourecordno1                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）同種レコード番号１ */
     zrnkahensuu1                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）可変項目数１ */
     zrnkahenketa1                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）可変項目桁数１ */
     zrnkahen1                                          CHAR        (234)                                                     NOT NULL  ,  /* （連携用）可変項目１ */
     zrndatakbn5                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分５ */
     zrndtrecordkbn4                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データレコード区分４ */
     zrndourecordsuu2                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）同種レコード数２ */
     zrndourecordno2                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）同種レコード番号２ */
     zrnkahensuu2                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）可変項目数２ */
     zrnkahenketa2                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）可変項目桁数２ */
     zrnkahen2                                          CHAR        (234)                                                     NOT NULL  ,  /* （連携用）可変項目２ */
     zrndatakbn6                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分６ */
     zrndtrecordkbn5                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データレコード区分５ */
     zrndourecordsuu3                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）同種レコード数３ */
     zrndourecordno3                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）同種レコード番号３ */
     zrnkahensuu3                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）可変項目数３ */
     zrnkahenketa3                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）可変項目桁数３ */
     zrnkahen3                                          CHAR        (234)                                                     NOT NULL     /* （連携用）可変項目３ */
)
;

ALTER TABLE ZT_OnlineGknyknmeisaiRn_Z ADD CONSTRAINT PK_OnlineGknyknmeisaiRn PRIMARY KEY (
     zrnsakuseiymd                                            , /* （連携用）作成日 */
     zrnrenrakuymd                                            , /* （連携用）連絡日 */
     zrnrenrakukaisuu                                         , /* （連携用）連絡回数 */
     zrnbankcd                                                , /* （連携用）銀行番号 */
     zrnshitencd                                              , /* （連携用）支店番号 */
     zrnyokinkbn                                              , /* （連携用）預金種目区分 */
     zrnkouzano                                               , /* （連携用）口座番号 */
     zrnzndktuukasyu                                          , /* （連携用）残高通貨種類 */
     zrnsyorino1                                                /* （連携用）処理通番１ */
) ;
