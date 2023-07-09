CREATE TABLE BT_SikinIdouRireki (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     keirisyorirenno                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 経理用処理連番 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     targetKinouId                                      VARCHAR     (50)                                                                ,  /* 対象機能ＩＤ */
     skno                                               VARCHAR     (18)                                                                ,  /* 請求番号 */
     seikyuurirekino                                    NUMBER      (3)                                                                 ,  /* 請求履歴番号 */
     sakujyoflg                                         VARCHAR     (1)                                                                 ,  /* 削除フラグ */
     nykshrkbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 入金支払区分 */
     syoricd                                            VARCHAR     (4)                                                       NOT NULL  ,  /* 処理コード */
     densyskbn                                          VARCHAR     (2)                                                                 ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     seg1cd                                             VARCHAR     (20)                                                      NOT NULL  ,  /* セグメント１コード */
     kyktuukasyu                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 契約通貨種類 */
     syutkkbn                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約特約区分 */
     hrkkaisuu                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 払込回数 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyksyouhnrenno                                     NUMBER      (2)                                                       NOT NULL  ,  /* 契約商品連番 */
     shrhousiteikbn                                     VARCHAR     (1)                                                                 ,  /* 支払方法指定区分 */
     phendoukaisiym                                     VARCHAR     (6)                                                                 ,  /* Ｐ変動開始年月 */
     phendoumaegk                                       VARCHAR     (13)                                                                ,  /* Ｐ変動前金額 */
     phendoumaegk$                                      VARCHAR     (10)                                                                ,  /* Ｐ変動前金額(通貨型) */
     phendougogk                                        VARCHAR     (13)                                                                ,  /* Ｐ変動後金額 */
     phendougogk$                                       VARCHAR     (10)                                                                ,  /* Ｐ変動後金額(通貨型) */
     kykymd                                             VARCHAR     (8)                                                       NOT NULL  ,  /* 契約日 */
     seirituymd                                         VARCHAR     (8)                                                                 ,  /* 成立日 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     misyuupjyuutouym                                   VARCHAR     (6)                                                                 ,  /* 未収保険料充当年月 */
     shrsyorikbn                                        VARCHAR     (2)                                                                 ,  /* 支払処理区分 */
     seikyuusyubetu                                     VARCHAR     (2)                                                                 ,  /* 請求種別 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     jyutoustartym                                      VARCHAR     (6)                                                                 ,  /* 充当開始年月 */
     jyutouendym                                        VARCHAR     (6)                                                                 ,  /* 充当終了年月 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     nyktrksflg                                         VARCHAR     (1)                                                                 ,  /* 入金取消フラグ */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     hokenryou                                          NUMBER      (13)                                                                ,  /* 保険料 */
     hokenryou$                                         VARCHAR     (10)                                                                ,  /* 保険料(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_SikinIdouRireki ADD CONSTRAINT PK_SikinIdouRireki PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     keirisyorirenno                                            /* 経理用処理連番 */
) ;

CREATE INDEX IX1_SikinIdouRireki ON BT_SikinIdouRireki (
     syono                                                      /* 証券番号 */
) ;
