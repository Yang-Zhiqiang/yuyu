CREATE TABLE ZT_KoujyoSyoumeiTy_Z (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztysyodouhuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）証券同封区分 */
     ztysikibetuno                                      VARCHAR     (20)                                                                ,  /* （中継用）識別番号 */
     ztykoujyosyoumeisentakukbn                         VARCHAR     (1)                                                                 ,  /* （中継用）控除証明選択区分 */
     ztyyobiv43                                         VARCHAR     (43)                                                                ,  /* （中継用）予備項目Ｖ４３ */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）送付先名（漢字） */
     ztyyobiv1                                          VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１ */
     ztykyknmkn                                         VARCHAR     (38)                                                                ,  /* （中継用）契約者名（カナ） */
     ztyuktnmkn                                         VARCHAR     (38)                                                                ,  /* （中継用）受取人名（カナ） */
     ztytawsosikikj                                     VARCHAR     (32)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (32)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta                                    VARCHAR     (15)                                                      NOT NULL  ,  /* （中継用）作成番号（１５桁） */
     ztyyobiv48                                         VARCHAR     (48)                                                                ,  /* （中継用）予備項目Ｖ４８ */
     ztykyknmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）契約者名（漢字） */
     ztysyoumeinndseireki                               VARCHAR     (12)                                                                ,  /* （中継用）証明年度（西暦） */
     ztyuktnmknmeikj                                    VARCHAR     (36)                                                                ,  /* （中継用）受取人名（漢字） */
     ztynenkinuktseiymdseireki                          VARCHAR     (24)                                                                ,  /* （中継用）年金受取人生年月日（西暦） */
     ztysyono3                                          VARCHAR     (11)                                                                ,  /* （中継用）証券番号３ */
     ztyhknsyurui                                       VARCHAR     (32)                                                                ,  /* （中継用）保険種類 */
     ztynknshrynnm                                      VARCHAR     (2)                                                                 ,  /* （中継用）年金支払期間（数） */
     ztykykymdseireki                                   VARCHAR     (24)                                                                ,  /* （中継用）契約年月日（西暦） */
     ztyhtkinuthoukbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）配当金受取方法区分 */
     ztyhknkknnm                                        VARCHAR     (2)                                                                 ,  /* （中継用）保険期間（数） */
     ztynkshrstartymdseireki                            VARCHAR     (24)                                                                ,  /* （中継用）年金支払開始日（西暦） */
     ztyphrkkkn                                         VARCHAR     (2)                                                                 ,  /* （中継用）保険料払込期間 */
     ztyhrkkaisuunm                                     VARCHAR     (2)                                                                 ,  /* （中継用）払込回数（数） */
     ztykjnnkkoujyum                                    VARCHAR     (1)                                                                 ,  /* （中継用）個人年金控除有無 */
     ztyuktmidasi                                       VARCHAR     (8)                                                                 ,  /* （中継用）受取人見出し */
     ztymidasisub                                       VARCHAR     (12)                                                                ,  /* （中継用）見出し副題 */
     ztykoujyosyoumeifreearea                           VARCHAR     (22)                                                                ,  /* （中継用）控除証明書フリーエリア */
     ztyyobiv13                                         VARCHAR     (13)                                                                ,  /* （中継用）予備項目Ｖ１３ */
     ztyippanseimeip                                    VARCHAR     (10)                                                                ,  /* （中継用）一般生命保険料（新制度） */
     ztyippanhaitoukin                                  VARCHAR     (10)                                                                ,  /* （中継用）一般配当金（新制度） */
     ztyippansyoumeigk                                  VARCHAR     (10)                                                                ,  /* （中継用）一般証明額（新制度） */
     ztykaigoiryoup                                     VARCHAR     (10)                                                                ,  /* （中継用）介護医療保険料（新制度） */
     ztykaigoiryoud                                     VARCHAR     (10)                                                                ,  /* （中継用）介護医療配当金（新制度） */
     ztykaigoiryousmgk                                  VARCHAR     (10)                                                                ,  /* （中継用）介護医療証明額（新制度） */
     ztynenkinp                                         VARCHAR     (10)                                                                ,  /* （中継用）年金保険料（新制度） */
     ztynenkind                                         VARCHAR     (10)                                                                ,  /* （中継用）年金配当金（新制度） */
     ztynenkinsmgk                                      VARCHAR     (10)                                                                ,  /* （中継用）年金証明額（新制度） */
     ztynewhknjytukikan                                 VARCHAR     (38)                                                                ,  /* （中継用）新制度保険充当期間 */
     ztyphrkkknjyoutai                                  VARCHAR     (10)                                                                ,  /* （中継用）保険料払込状態 */
     ztysyoumeiymdseireki                               VARCHAR     (24)                                                                ,  /* （中継用）証明日（西暦） */
     ztynenippanseimeip                                 VARCHAR     (10)                                                                ,  /* （中継用）年間一般生命保険料（新制度） */
     ztynenippand                                       VARCHAR     (10)                                                                ,  /* （中継用）年間一般配当金（新制度） */
     ztynenippansymgk                                   VARCHAR     (10)                                                                ,  /* （中継用）年間一般証明額（新制度） */
     ztynenkaigoiryoup                                  VARCHAR     (10)                                                                ,  /* （中継用）年間介護医療保険料（新制度） */
     ztynenkaigoiryoud                                  VARCHAR     (10)                                                                ,  /* （中継用）年間介護医療配当金（新制度） */
     ztyneniryousymgk                                   VARCHAR     (10)                                                                ,  /* （中継用）年間介護医療証明額（新制度） */
     ztynennenkinp                                      VARCHAR     (10)                                                                ,  /* （中継用）年間年金保険料（新制度） */
     ztynennenkind                                      VARCHAR     (10)                                                                ,  /* （中継用）年間年金配当金（新制度） */
     ztynennenkinsmgk                                   VARCHAR     (10)                                                                ,  /* （中継用）年間年金証明額（新制度） */
     ztyyobiv24                                         VARCHAR     (24)                                                                ,  /* （中継用）予備項目Ｖ２４ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KoujyoSyoumeiTy_Z ADD CONSTRAINT PK_KoujyoSyoumeiTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztysakunm15keta                                            /* （中継用）作成番号（１５桁） */
) ;
