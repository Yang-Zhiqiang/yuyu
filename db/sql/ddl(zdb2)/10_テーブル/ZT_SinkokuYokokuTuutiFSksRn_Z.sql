CREATE TABLE ZT_SinkokuYokokuTuutiFSksRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdwa                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（和暦） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
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
     zrnsakunm                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）作成番号 */
     zrnkyknmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字） */
     zrnsinkokunenwareki                                GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）申告年（和暦） */
     zrnmidasi1                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し１ */
     zrnmidasi2                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し２ */
     zrnmidasi3                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し３ */
     zrnmidasi4                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し４ */
     zrnmidasi5                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し５ */
     zrnmidasi6                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し６ */
     zrnmidasi7                                         GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）見出し７ */
     zrnkihonjouhoumongon1                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言１ */
     zrnkihonjouhoumongon2                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言２ */
     zrnkihonjouhoumongon3                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言３ */
     zrnkihonjouhoumongon4                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言４ */
     zrnkihonjouhoumongon5                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言５ */
     zrnkihonjouhoumongon6                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言６ */
     zrnkihonjouhoumongon7                              GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）基本情報文言７ */
     zrnippanseimeipyoteigk                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）一般生命保険料予定額（新制度） */
     zrnippanhaitoukinyoteigk                           CHAR        (13)                                                      NOT NULL  ,  /* （連携用）一般配当金予定額（新制度） */
     zrnippansinkokuyoteigk                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）一般申告予定額（新制度） */
     zrnkaigoiryoupyoteigk                              CHAR        (13)                                                      NOT NULL  ,  /* （連携用）介護医療保険料予定額（新制度） */
     zrnkaigoiryoudyoteigk                              CHAR        (13)                                                      NOT NULL  ,  /* （連携用）介護医療配当金予定額（新制度） */
     zrnkaigoiryousinkokuyoteigk                        CHAR        (13)                                                      NOT NULL  ,  /* （連携用）介護医療申告予定額（新制度） */
     zrnnenkinpyoteigk                                  CHAR        (13)                                                      NOT NULL  ,  /* （連携用）年金保険料予定額（新制度） */
     zrnnenkindyoteigk                                  CHAR        (13)                                                      NOT NULL  ,  /* （連携用）年金配当金予定額（新制度） */
     zrnnenkinsinkokuyoteigk                            CHAR        (13)                                                      NOT NULL  ,  /* （連携用）年金申告予定額（新制度） */
     zrnnewhknjytukikan                                 GRAPHIC     (18)                                                      NOT NULL  ,  /* （連携用）新制度保険充当期間 */
     zrnkykymdwa                                        GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（和暦） */
     zrnhrkkaisuunm                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払込回数（数） */
     zrnsakuseiymdwareki                                GRAPHIC     (11)                                                      NOT NULL     /* （連携用）作成年月日（和暦） */
)
;

ALTER TABLE ZT_SinkokuYokokuTuutiFSksRn_Z ADD CONSTRAINT PK_SinkokuYokokuTuutiFSksRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnsinkokunenwareki                                        /* （連携用）申告年（和暦） */
) ;
