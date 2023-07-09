CREATE TABLE ZT_KzhuriAnnaiUlfTy (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztydantaicd                                        VARCHAR     (8)                                                                 ,  /* （中継用）団体コード */
     ztykzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （中継用）口座振替口座番号 */
     ztykzhurikaeannaikbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替案内区分 */
     ztyhurikaeymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）振替年月日 */
     ztyrsgaku                                          NUMBER      (11)                                                                ,  /* （中継用）領収金額 */
     ztyjyuutouym                                       VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）充当年月 */
     ztyjyuutounensuu                                   VARCHAR     (2)                                                                 ,  /* （中継用）充当年数 */
     ztyjyuutoutukisuu                                  VARCHAR     (2)                                                                 ,  /* （中継用）充当月数 */
     ztydantaikobetukbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）団体個別区分 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztynyknaiyou                                       VARCHAR     (2)                                                                 ,  /* （中継用）入金内容 */
     ztyaatukaisosikicd                                 VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱者組織コード */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztykzhurikaetkbtannaihyj                           VARCHAR     (1)                                                                 ,  /* （中継用）口座振替特別案内表示 */
     ztyhrkgk                                           NUMBER      (11)                                                                ,  /* （中継用）払込額 */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿３ */
     ztytsnsknewyno                                     VARCHAR     (7)                                                                 ,  /* （中継用）通信先新郵便番号 */
     ztytsnsknewtikucd                                  VARCHAR     (1)                                                                 ,  /* （中継用）通信先新地区コード */
     ztyaatukaikojincd                                  VARCHAR     (6)                                                                 ,  /* （中継用）Ａ扱者個人コード */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyteikeisyouhinhyj                                VARCHAR     (1)                                                                 ,  /* （中継用）提携商品表示 */
     ztykzmeiginmei                                     VARCHAR     (30)                                                                ,  /* （中継用）口座名義人名 */
     ztykeizokup                                        NUMBER      (11)                                                                ,  /* （中継用）継続保険料 */
     ztyiktwaribikikgk                                  NUMBER      (11)                                                                ,  /* （中継用）一括割引額 */
     ztykeizokupnaiyoukbn                               VARCHAR     (2)                                                                 ,  /* （中継用）継続Ｐ内容区分 */
     ztyhisaijiannaitsghyj                              VARCHAR     (1)                                                                 ,  /* （中継用）被災時案内対象外表示 */
     ztydaisyono                                        VARCHAR     (11)                                                                ,  /* （中継用）代表証券番号 */
     ztykzhurisyuudaikokbn                              VARCHAR     (1)                                                                 ,  /* （中継用）口座振替収納代行会社区分 */
     ztyyobiv17                                         VARCHAR     (17)                                                                ,  /* （中継用）予備項目Ｖ１７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_KzhuriAnnaiUlfTy ADD CONSTRAINT PK_KzhuriAnnaiUlfTy PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztyjyuutouym                                               /* （中継用）充当年月 */
) ;
