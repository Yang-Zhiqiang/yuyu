CREATE TABLE IT_BAK_KoujyoSymNaiyou (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     koujyosyoumeinnd                                   VARCHAR     (4)                                                                 ,  /* 控除証明年度 */
     syoumeistartym                                     VARCHAR     (6)                                                                 ,  /* 証明開始年月 */
     syoumeiendym                                       VARCHAR     (6)                                                                 ,  /* 証明終了年月 */
     koujyosyoumeipkbn                                  VARCHAR     (1)                                                                 ,  /* 控除証明保険料区分 */
     tekiyouseidokbn                                    VARCHAR     (1)                                                                 ,  /* 適用制度区分 */
     koujyosymnaiyoureckbn                              VARCHAR     (2)                                                                 ,  /* 控除証明内容レコード区分 */
     koujyosyoumeigk                                    NUMBER      (13)                                                                ,  /* 控除証明額 */
     koujyosyoumeigk$                                   VARCHAR     (10)                                                                ,  /* 控除証明額(通貨型) */
     jyutoustartym                                      VARCHAR     (6)                                                                 ,  /* 充当開始年月 */
     nyknjskrrkrenno                                    NUMBER      (2)                                                                 ,  /* 入金実績履歴連番 */
     kihrkpssrrkrenno                                   NUMBER      (2)                                                                 ,  /* 既払込Ｐ精算履歴連番 */
     kjsmhakkouzumiflg                                  VARCHAR     (1)                                                                 ,  /* 控除証明書発行済フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     sakujyoflg                                         VARCHAR     (1)                                                                 ,  /* 削除フラグ */
     zennoukaisiymd                                     VARCHAR     (8)                                                                 ,  /* 前納開始年月日 */
     zennourenno                                        NUMBER      (2)                                                                 ,  /* 前納連番 */
     keisanhukahyoujikbn                                VARCHAR     (1)                                                                 ,  /* 計算不可表示区分 */
     keisanhukariyuucd                                  VARCHAR     (4)                                                                    /* 計算不可理由コード */
)
;

ALTER TABLE IT_BAK_KoujyoSymNaiyou ADD CONSTRAINT PK_BAK_KoujyoSymNaiyou PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     syouhncd                                                 , /* 商品コード */
     renno3keta                                                 /* 連番（３桁） */
) ;
