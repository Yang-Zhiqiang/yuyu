CREATE TABLE ZT_KoujyoSyoumeiRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrnsyodouhuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）証券同封区分 */
     zrnsikibetuno                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）識別番号 */
     zrnkoujyosyoumeisentakukbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）控除証明選択区分 */
     zrnyobiv43                                         CHAR        (43)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４３ */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrnkyknmkn                                         GRAPHIC     (18)                                                      NOT NULL  ,  /* （連携用）契約者名（カナ） */
     zrnuktnmkn                                         GRAPHIC     (18)                                                      NOT NULL  ,  /* （連携用）受取人名（カナ） */
     zrntawsosikikj                                     GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先組織名（漢字） */
     zrntawyno                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1                                GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2                                GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj                               GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno                                    CHAR        (14)                                                      NOT NULL  ,  /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta                                    CHAR        (15)                                                      NOT NULL  ,  /* （連携用）作成番号（１５桁） */
     zrnyobiv48                                         CHAR        (48)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４８ */
     zrnkyknmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字） */
     zrnsyoumeinndseireki                               GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）証明年度（西暦） */
     zrnuktnmknmeikj                                    GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）受取人名（漢字） */
     zrnnenkinuktseiymdseireki                          GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）年金受取人生年月日（西暦） */
     zrnsyono3                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号３ */
     zrnhknsyurui                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）保険種類 */
     zrnnknshrynnm                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）年金支払期間（数） */
     zrnkykymdseireki                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（西暦） */
     zrnhtkinuthoukbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）配当金受取方法区分 */
     zrnhknkknnm                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間（数） */
     zrnnkshrstartymdseireki                            GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）年金支払開始日（西暦） */
     zrnphrkkkn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険料払込期間 */
     zrnhrkkaisuunm                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払込回数（数） */
     zrnkjnnkkoujyum                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）個人年金控除有無 */
     zrnuktmidasi                                       GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）受取人見出し */
     zrnmidasisub                                       GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）見出し副題 */
     zrnkoujyosyoumeifreearea                           GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）控除証明書フリーエリア */
     zrnyobiv13                                         CHAR        (13)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１３ */
     zrnippanseimeip                                    CHAR        (10)                                                      NOT NULL  ,  /* （連携用）一般生命保険料（新制度） */
     zrnippanhaitoukin                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）一般配当金（新制度） */
     zrnippansyoumeigk                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）一般証明額（新制度） */
     zrnkaigoiryoup                                     CHAR        (10)                                                      NOT NULL  ,  /* （連携用）介護医療保険料（新制度） */
     zrnkaigoiryoud                                     CHAR        (10)                                                      NOT NULL  ,  /* （連携用）介護医療配当金（新制度） */
     zrnkaigoiryousmgk                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）介護医療証明額（新制度） */
     zrnnenkinp                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年金保険料（新制度） */
     zrnnenkind                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年金配当金（新制度） */
     zrnnenkinsmgk                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年金証明額（新制度） */
     zrnnewhknjytukikan                                 GRAPHIC     (18)                                                      NOT NULL  ,  /* （連携用）新制度保険充当期間 */
     zrnphrkkknjyoutai                                  GRAPHIC     (4)                                                       NOT NULL  ,  /* （連携用）保険料払込状態 */
     zrnsyoumeiymdseireki                               GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）証明日（西暦） */
     zrnnenippanseimeip                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間一般生命保険料（新制度） */
     zrnnenippand                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間一般配当金（新制度） */
     zrnnenippansymgk                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間一般証明額（新制度） */
     zrnnenkaigoiryoup                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間介護医療保険料（新制度） */
     zrnnenkaigoiryoud                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間介護医療配当金（新制度） */
     zrnneniryousymgk                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間介護医療証明額（新制度） */
     zrnnennenkinp                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間年金保険料（新制度） */
     zrnnennenkind                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間年金配当金（新制度） */
     zrnnennenkinsmgk                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）年間年金証明額（新制度） */
     zrnyobiv24                                         CHAR        (24)                                                      NOT NULL     /* （連携用）予備項目Ｖ２４ */
)
;

ALTER TABLE ZT_KoujyoSyoumeiRn_Z ADD CONSTRAINT PK_KoujyoSyoumeiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnsakunm15keta                                            /* （連携用）作成番号（１５桁） */
) ;
