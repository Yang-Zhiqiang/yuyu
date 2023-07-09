CREATE TABLE ZT_KzhuriAnnaiUlfRn (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrndantaicd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）団体コード */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrnkzhurikaeannaikbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替案内区分 */
     zrnhurikaeymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）振替年月日 */
     zrnrsgaku                                          NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）領収金額 */
     zrnjyuutouym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）充当年月 */
     zrnjyuutounensuu                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）充当年数 */
     zrnjyuutoutukisuu                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）充当月数 */
     zrndantaikobetukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）団体個別区分 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnnyknaiyou                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）入金内容 */
     zrnaatukaisosikicd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者組織コード */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnkzhurikaetkbtannaihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替特別案内表示 */
     zrnhrkgk                                           NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）払込額 */
     zrnyobin11                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿３ */
     zrntsnsknewyno                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）通信先新郵便番号 */
     zrntsnsknewtikucd                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通信先新地区コード */
     zrnaatukaikojincd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ａ扱者個人コード */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnteikeisyouhinhyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）提携商品表示 */
     zrnkzmeiginmei                                     CHAR        (30)                                                      NOT NULL  ,  /* （連携用）口座名義人名 */
     zrnkeizokup                                        NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）継続保険料 */
     zrniktwaribikikgk                                  NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）一括割引額 */
     zrnkeizokupnaiyoukbn                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）継続Ｐ内容区分 */
     zrnhisaijiannaitsghyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被災時案内対象外表示 */
     zrndaisyono                                        CHAR        (11)                                                      NOT NULL  ,  /* （連携用）代表証券番号 */
     zrnkzhurisyuudaikokbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替収納代行会社区分 */
     zrnyobiv17                                         CHAR        (17)                                                      NOT NULL     /* （連携用）予備項目Ｖ１７ */
)
;

ALTER TABLE ZT_KzhuriAnnaiUlfRn ADD CONSTRAINT PK_KzhuriAnnaiUlfRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnjyuutouym                                               /* （連携用）充当年月 */
) ;
