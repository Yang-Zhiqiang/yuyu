CREATE TABLE IT_HrkeIraiInfo (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     hrkeannaijkkbn                                     VARCHAR     (1)                                                                 ,  /* 振替案内状況区分 */
     hrkeyousiymd                                       VARCHAR     (8)                                                                 ,  /* 振替用紙作成日 */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     torikesiymd                                        VARCHAR     (8)                                                                 ,  /* 取消日 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     hrkkigen                                           VARCHAR     (8)                                                                 ,  /* 払込期限 */
     hrkiraikngk                                        NUMBER      (9)                                                                 ,  /* 払込依頼金額 */
     hrkiraikngk$                                       VARCHAR     (10)                                                                ,  /* 払込依頼金額(通貨型) */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     kzkpannaijiyuukbn                                  VARCHAR     (1)                                                                 ,  /* 継続Ｐ案内事由区分 */
     comment124keta                                     VARCHAR     (124)                                                               ,  /* コメント（１２４桁） */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_HrkeIraiInfo ADD CONSTRAINT PK_HrkeIraiInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
