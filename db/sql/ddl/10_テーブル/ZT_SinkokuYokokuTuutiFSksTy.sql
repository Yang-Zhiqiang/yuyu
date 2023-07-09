CREATE TABLE ZT_SinkokuYokokuTuutiFSksTy (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdwa                                   VARCHAR     (11)                                                                ,  /* （中継用）帳票作成日（和暦） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (30)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (30)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (30)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (15)                                                                ,  /* （中継用）送付先名（漢字） */
     ztytawsosikikj                                     VARCHAR     (15)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (15)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (15)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (15)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (25)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (25)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (15)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm                                          VARCHAR     (7)                                                                 ,  /* （中継用）作成番号 */
     ztykyknmkj                                         VARCHAR     (15)                                                                ,  /* （中継用）契約者名（漢字） */
     ztysinkokunenwareki                                VARCHAR     (5)                                                       NOT NULL  ,  /* （中継用）申告年（和暦） */
     ztymidasi1                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し１ */
     ztymidasi2                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し２ */
     ztymidasi3                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し３ */
     ztymidasi4                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し４ */
     ztymidasi5                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し５ */
     ztymidasi6                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し６ */
     ztymidasi7                                         VARCHAR     (8)                                                                 ,  /* （中継用）見出し７ */
     ztykihonjouhoumongon1                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言１ */
     ztykihonjouhoumongon2                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言２ */
     ztykihonjouhoumongon3                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言３ */
     ztykihonjouhoumongon4                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言４ */
     ztykihonjouhoumongon5                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言５ */
     ztykihonjouhoumongon6                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言６ */
     ztykihonjouhoumongon7                              VARCHAR     (17)                                                                ,  /* （中継用）基本情報文言７ */
     ztyippanseimeipyoteigk                             VARCHAR     (13)                                                                ,  /* （中継用）一般生命保険料予定額（新制度） */
     ztyippanhaitoukinyoteigk                           VARCHAR     (13)                                                                ,  /* （中継用）一般配当金予定額（新制度） */
     ztyippansinkokuyoteigk                             VARCHAR     (13)                                                                ,  /* （中継用）一般申告予定額（新制度） */
     ztykaigoiryoupyoteigk                              VARCHAR     (13)                                                                ,  /* （中継用）介護医療保険料予定額（新制度） */
     ztykaigoiryoudyoteigk                              VARCHAR     (13)                                                                ,  /* （中継用）介護医療配当金予定額（新制度） */
     ztykaigoiryousinkokuyoteigk                        VARCHAR     (13)                                                                ,  /* （中継用）介護医療申告予定額（新制度） */
     ztynenkinpyoteigk                                  VARCHAR     (13)                                                                ,  /* （中継用）年金保険料予定額（新制度） */
     ztynenkindyoteigk                                  VARCHAR     (13)                                                                ,  /* （中継用）年金配当金予定額（新制度） */
     ztynenkinsinkokuyoteigk                            VARCHAR     (13)                                                                ,  /* （中継用）年金申告予定額（新制度） */
     ztynewhknjytukikan                                 VARCHAR     (18)                                                                ,  /* （中継用）新制度保険充当期間 */
     ztykykymdwa                                        VARCHAR     (11)                                                                ,  /* （中継用）契約年月日（和暦） */
     ztyhrkkaisuunm                                     VARCHAR     (2)                                                                 ,  /* （中継用）払込回数（数） */
     ztysakuseiymdwareki                                VARCHAR     (11)                                                                ,  /* （中継用）作成年月日（和暦） */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SinkokuYokokuTuutiFSksTy ADD CONSTRAINT PK_SinkokuYokokuTuutiFSksTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztysinkokunenwareki                                        /* （中継用）申告年（和暦） */
) ;
