CREATE TABLE IT_AnsyuRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                       NOT NULL  ,  /* 入金内容区分 */
     jyuutouym                                          VARCHAR     (6)                                                       NOT NULL  ,  /* 充当年月 */
     annaino                                            NUMBER      (2)                                                       NOT NULL  ,  /* 案内番号 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     iktwaribikikgk                                     NUMBER      (13)                                                                ,  /* 一括割引料 */
     iktwaribikikgk$                                    VARCHAR     (10)                                                                ,  /* 一括割引料(通貨型) */
     annaijkkbn                                         VARCHAR     (1)                                                                 ,  /* 案内状況区分 */
     annaisakuseiymd                                    VARCHAR     (8)                                                                 ,  /* 案内作成日 */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     minyusyoriymd                                      VARCHAR     (8)                                                                 ,  /* 未入処理日 */
     dattaiuktkymd                                      VARCHAR     (8)                                                                 ,  /* 脱退受付日 */
     hurikaeymd                                         VARCHAR     (8)                                                                 ,  /* 振替日 */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     uriageymdkon                                       VARCHAR     (8)                                                                 ,  /* 売上日（今回） */
     krkkeijyoflg                                       VARCHAR     (1)                                                                 ,  /* 仮受計上フラグ */
     krkkeijyoymd                                       VARCHAR     (8)                                                                 ,  /* 仮受計上処理日 */
     krkno                                              NUMBER      (5)                                                                 ,  /* 仮受番号 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     syuudaikocd                                        VARCHAR     (2)                                                                 ,  /* 収納代行社コード */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     sinkeizkkbn                                        VARCHAR     (1)                                                                 ,  /* 新規継続区分 */
     syuyakukyohikbn                                    VARCHAR     (1)                                                                 ,  /* 集約拒否区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     yukoukachkymd                                      VARCHAR     (8)                                                                 ,  /* 有効性確認日 */
     authorikanryoymd                                   VARCHAR     (8)                                                                 ,  /* オーソリ完了日 */
     uriageymdzen                                       VARCHAR     (8)                                                                 ,  /* 売上日（前回） */
     hrkkigen                                           VARCHAR     (8)                                                                 ,  /* 払込期限 */
     minyutuutizumiflg                                  VARCHAR     (1)                                                                 ,  /* 未入通知作成済フラグ */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     credituriagengjiyuu                                VARCHAR     (2)                                                                 ,  /* クレジットカード売上請求ＮＧ事由 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_AnsyuRireki ADD CONSTRAINT PK_AnsyuRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     nyknaiyoukbn                                             , /* 入金内容区分 */
     jyuutouym                                                , /* 充当年月 */
     annaino                                                    /* 案内番号 */
) ;

CREATE INDEX IX1_AnsyuRireki ON IT_AnsyuRireki (
     syono                                                    , /* 証券番号 */
     nyknaiyoukbn                                             , /* 入金内容区分 */
     jyuutouym                                                , /* 充当年月 */
     annaino                                                    /* 案内番号 */
) ;
