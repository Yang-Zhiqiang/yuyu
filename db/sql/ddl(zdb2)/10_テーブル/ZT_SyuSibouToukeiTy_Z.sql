CREATE TABLE ZT_SyuSibouToukeiTy_Z (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyurui2keta                                  VARCHAR     (2)                                                                 ,  /* （中継用）保険種類（２桁） */
     ztyatukaibetu                                      VARCHAR     (1)                                                                 ,  /* （中継用）扱別 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyhhknnen3                                        VARCHAR     (3)                                                                 ,  /* （中継用）被保険者年令（３文字） */
     ztytoutatunenrei                                   VARCHAR     (3)                                                                 ,  /* （中継用）到達年齢 */
     ztykykym                                           VARCHAR     (6)                                                                 ,  /* （中継用）契約年月 */
     ztysymtym                                          VARCHAR     (6)                                                                 ,  /* （中継用）消滅年月 */
     ztysyoriymd                                        VARCHAR     (8)                                                                 ,  /* （中継用）処理年月日 */
     ztykyktuuka                                        VARCHAR     (1)                                                                 ,  /* （中継用）契約通貨 */
     ztyimustiyusbus                                    DECIMAL     (7)                                                                 ,  /* （中継用）医務査定用死亡Ｓ */
     ztysykgycd                                         VARCHAR     (3)                                                                 ,  /* （中継用）職業コード */
     ztyhrkhuhukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）払込方法区分 */
     ztysirajikykkbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）白地契約区分 */
     ztyaatukaisosikicd                                 VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱者組織コード */
     ztyaatukaikojincd                                  VARCHAR     (6)                                                                 ,  /* （中継用）Ａ扱者個人コード */
     ztysinsahouhou                                     VARCHAR     (2)                                                                 ,  /* （中継用）診査方法 */
     ztysinsasyacd                                      VARCHAR     (6)                                                                 ,  /* （中継用）診査者コード */
     ztyketteikekkakbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）決定結果区分 */
     ztydakuhikettisyacd                                VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定者コード */
     ztysyoubyoutyuubunrui                              VARCHAR     (2)                                                                 ,  /* （中継用）傷病中分類１ */
     ztysyoubyoucd1x5                                   VARCHAR     (5)                                                                 ,  /* （中継用）傷病コード１（５文字） */
     ztysyoubyoucd2x5                                   VARCHAR     (5)                                                                 ,  /* （中継用）傷病コード２（５文字） */
     ztydaisiincd                                       VARCHAR     (1)                                                                 ,  /* （中継用）大死因コード */
     ztytyuusiincd                                      VARCHAR     (2)                                                                 ,  /* （中継用）中死因コード */
     ztysyousiincd                                      VARCHAR     (3)                                                                 ,  /* （中継用）小死因コード */
     ztysoukisibouhyj                                   VARCHAR     (1)                                                                 ,  /* （中継用）早期死亡表示 */
     ztykeikakikankbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）経過期間区分 */
     ztykoudosyougaiarihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）高度障害有表示 */
     ztykaijyokbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）解除区分 */
     ztynensyuukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）年収区分 */
     ztyhanbaikeirokbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）販売経路区分 */
     ztyoyadairitencd                                   VARCHAR     (7)                                                                 ,  /* （中継用）親代理店コード */
     ztybyoumeicd                                       VARCHAR     (4)                                                                 ,  /* （中継用）病名コード */
     ztysyksbyensitihsyutyhkumu                         VARCHAR     (1)                                                                 ,  /* （中継用）初期死亡時円換算最低保証特約付加有無 */
     ztyjyudkaigomehrtkhkumu                            VARCHAR     (1)                                                                 ,  /* （中継用）重度介護前払特約付加有無 */
     ztyijitoukeizennoukbn                              VARCHAR     (1)                                                                 ,  /* （中継用）医事統計用前納区分 */
     ztydai1hknkkn                                      VARCHAR     (2)                                                                 ,  /* （中継用）第１保険期間 */
     ztyijitoukeitikshrtkykkbn                          VARCHAR     (1)                                                                 ,  /* （中継用）医事統計用定期支払特約区分 */
     ztyteikisiharaikinmanen                            DECIMAL     (7)                                                                 ,  /* （中継用）定期支払金（万円） */
     ztyyobiv78                                         VARCHAR     (78)                                                                ,  /* （中継用）予備項目Ｖ７８ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SyuSibouToukeiTy_Z ADD CONSTRAINT PK_SyuSibouToukeiTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;
