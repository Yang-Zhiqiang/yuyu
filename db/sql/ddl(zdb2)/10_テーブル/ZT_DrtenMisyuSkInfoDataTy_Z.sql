CREATE TABLE ZT_DrtenMisyuSkInfoDataTy_Z (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyhnsyugknjkyksynm                                VARCHAR     (32)                                                                ,  /* （中継用）編集後漢字契約者名 */
     ztyknjhhknmei                                      VARCHAR     (32)                                                                ,  /* （中継用）漢字被保険者名 */
     ztykykjyutikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）契約状態区分 */
     ztytsinkihontikucd                                 VARCHAR     (8)                                                                 ,  /* （中継用）通信先基本地区コード */
     ztykanjitsinkaiadr                                 VARCHAR     (126)                                                               ,  /* （中継用）漢字通信先下位住所 */
     ztytsintelno                                       VARCHAR     (14)                                                                ,  /* （中継用）通信先電話番号 */
     ztydai2tsintelno                                   VARCHAR     (14)                                                                ,  /* （中継用）第２通信先電話番号 */
     ztykzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （中継用）口座振替口座番号 */
     ztykzhurikaemeiginm                                VARCHAR     (30)                                                                ,  /* （中継用）口座振替名義人名 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyyobiv6x5                                        VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６＿５ */
     zty1kaip                                           DECIMAL     (11)                                                                ,  /* （中継用）１回分保険料 */
     ztynexthurikaeyoteigk                              DECIMAL     (11)                                                                ,  /* （中継用）次回振替予定金額 */
     ztyhrkyykknmnryymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）払込猶予期間満了日 */
     ztyskymd                                           VARCHAR     (8)                                                                 ,  /* （中継用）失効年月日 */
     ztyjhurikstkkahikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）自動振替貸付可否区分 */
     ztyhukkatumoskahikbn                               VARCHAR     (1)                                                                 ,  /* （中継用）復活申込可否区分 */
     ztyttdkkigenymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）手続き期限年月日 */
     ztyhukkatukanoukknmnryymd                          VARCHAR     (8)                                                                 ,  /* （中継用）復活可能期間満了年月日 */
     ztykeikatukisuu3keta                               VARCHAR     (3)                                                                 ,  /* （中継用）経過月数（３桁） */
     ztymisyuuhasseiym                                  VARCHAR     (6)                                                                 ,  /* （中継用）未収発生年月 */
     ztymisyuujiyuu                                     VARCHAR     (2)                                                                 ,  /* （中継用）未収事由 */
     ztyhanteiymd                                       VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）判定年月日 */
     ztyyobin11                                         DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztynexthurikaeymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）次回振替年月日 */
     ztyyobiv8x3                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿３ */
     ztyikkatubaraikbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu                               VARCHAR     (2)                                                                 ,  /* （中継用）一括払回数 */
     ztyyobiv55                                         VARCHAR     (55)                                                                ,  /* （中継用）予備項目Ｖ５５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_DrtenMisyuSkInfoDataTy_Z ADD CONSTRAINT PK_DrtenMisyuSkInfoDataTy PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztyhanteiymd                                               /* （中継用）判定年月日 */
) ;
