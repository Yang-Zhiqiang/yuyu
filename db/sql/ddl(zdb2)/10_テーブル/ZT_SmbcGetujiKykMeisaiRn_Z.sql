CREATE TABLE ZT_SmbcGetujiKykMeisaiRn_Z (
     zrndatakijyunymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）データ基準年月日 */
     zrndatakijyunym                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）データ基準年月 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnaatukaidirtncd                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱代理店コード */
     zrnbatukaidirtncd                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ｂ扱代理店コード */
     zrnaatukaibosyuunincd                              CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ａ扱募集人コード */
     zrnbatukaibosyuunincd                              CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ｂ扱募集人コード */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnmdhnaisyoumeicd                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）窓販用愛称名コード */
     zrntuukacdsmbcgetuji                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）通貨コード（ＳＭＢＣ月次契約Ｆ） */
     zrnhrkhuhukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込方法区分 */
     zrnkyknmknsmbcgetuji                               CHAR        (70)                                                      NOT NULL  ,  /* （連携用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ） */
     zrnkyknmkjsmbcgetuji                               GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ） */
     zrnhhknnmkjsmbcgetuji                              GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ） */
     zrnitijibrp                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）一時払保険料 */
     zrngoukeip2                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）合計保険料２ */
     zrnzenkizennoup                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）全期前納保険料 */
     zrntumitatekngk                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）積立金額 */
     zrntargettktoutatubi                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ターゲット到達日 */
     zrnmokuhyouti                                      DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）目標値 */
     zrnmokuhyoukngk                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）目標金額 */
     zrnkaiyakuhr                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約返戻金 */
     zrnhrkpjyuutouym                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）払込保険料充当年月 */
     zrnkihrpruikeigk                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払保険料累計額 */
     zrntousyokykjikawaserate                           DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）当初契約時為替レート */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnmankiymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）満期年月日 */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnyobiv56                                         CHAR        (56)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ５６ */
     zrngmeigyoubijikawaserate                          DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）月末営業日時為替レート */
     zrnyobiv16                                         CHAR        (16)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１６ */
     zrnsymtymd                                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）消滅年月日 */
     zrngetumatuymdidouw                                DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）月末日異動解約返戻金 */
     zrngetumatuymdsibous                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）月末日死亡保険金 */
     zrnyobiv53                                         CHAR        (53)                                                      NOT NULL     /* （連携用）予備項目Ｖ５３ */
)
;

ALTER TABLE ZT_SmbcGetujiKykMeisaiRn_Z ADD CONSTRAINT PK_SmbcGetujiKykMeisaiRn PRIMARY KEY (
     zrndatakijyunymd                                         , /* （連携用）データ基準年月日 */
     zrndatakijyunym                                          , /* （連携用）データ基準年月 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
