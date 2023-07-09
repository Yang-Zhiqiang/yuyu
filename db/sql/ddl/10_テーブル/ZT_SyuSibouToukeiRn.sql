CREATE TABLE ZT_SyuSibouToukeiRn (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyurui2keta                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類（２桁） */
     zrnatukaibetu                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）扱別 */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnhhknnen3                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）被保険者年令（３文字） */
     zrntoutatunenrei                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）到達年齢 */
     zrnkykym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）契約年月 */
     zrnsymtym                                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）消滅年月 */
     zrnsyoriymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理年月日 */
     zrnkyktuuka                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約通貨 */
     zrnimustiyusbus                                    NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）医務査定用死亡Ｓ */
     zrnsykgycd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）職業コード */
     zrnhrkhuhukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込方法区分 */
     zrnsirajikykkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）白地契約区分 */
     zrnaatukaisosikicd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者組織コード */
     zrnaatukaikojincd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ａ扱者個人コード */
     zrnsinsahouhou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）診査方法 */
     zrnsinsasyacd                                      CHAR        (6)                                                       NOT NULL  ,  /* （連携用）診査者コード */
     zrnketteikekkakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決定結果区分 */
     zrndakuhikettisyacd                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定者コード */
     zrnsyoubyoutyuubunrui                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）傷病中分類１ */
     zrnsyoubyoucd1x5                                   CHAR        (5)                                                       NOT NULL  ,  /* （連携用）傷病コード１（５文字） */
     zrnsyoubyoucd2x5                                   CHAR        (5)                                                       NOT NULL  ,  /* （連携用）傷病コード２（５文字） */
     zrndaisiincd                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）大死因コード */
     zrntyuusiincd                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）中死因コード */
     zrnsyousiincd                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）小死因コード */
     zrnsoukisibouhyj                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）早期死亡表示 */
     zrnkeikakikankbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）経過期間区分 */
     zrnkoudosyougaiarihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）高度障害有表示 */
     zrnkaijyokbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）解除区分 */
     zrnnensyuukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年収区分 */
     zrnhanbaikeirokbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）販売経路区分 */
     zrnoyadairitencd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）親代理店コード */
     zrnbyoumeicd                                       CHAR        (4)                                                       NOT NULL  ,  /* （連携用）病名コード */
     zrnsyksbyensitihsyutyhkumu                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初期死亡時円換算最低保証特約付加有無 */
     zrnjyudkaigomehrtkhkumu                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）重度介護前払特約付加有無 */
     zrnijitoukeizennoukbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）医事統計用前納区分 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnijitoukeitikshrtkykkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）医事統計用定期支払特約区分 */
     zrnteikisiharaikinmanen                            NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）定期支払金（万円） */
     zrnyobiv78                                         CHAR        (78)                                                      NOT NULL     /* （連携用）予備項目Ｖ７８ */
)
;

ALTER TABLE ZT_SyuSibouToukeiRn ADD CONSTRAINT PK_SyuSibouToukeiRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
