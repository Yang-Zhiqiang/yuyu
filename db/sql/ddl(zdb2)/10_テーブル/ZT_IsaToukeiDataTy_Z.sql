CREATE TABLE ZT_IsaToukeiDataTy_Z (
     ztymosno                                           VARCHAR     (9)                                                       NOT NULL  ,  /* （中継用）申込番号 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyhjykktkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）報状告知区分 */
     ztyhknsyuruicd                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類コード */
     ztyhrkhuhukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）払込方法区分 */
     ztymossyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）申込消滅区分 */
     ztymusymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）申込年月日 */
     ztymosym                                           VARCHAR     (6)                                                                 ,  /* （中継用）申込月度 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyaatukaisosikicd                                 VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱者組織コード */
     ztyaatukaikojincd                                  VARCHAR     (6)                                                                 ,  /* （中継用）Ａ扱者個人コード */
     ztyhhknnen3                                        VARCHAR     (3)                                                                 ,  /* （中継用）被保険者年令（３文字） */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztykyktuuka                                        VARCHAR     (1)                                                                 ,  /* （中継用）契約通貨 */
     ztysibous7                                         DECIMAL     (7)                                                                 ,  /* （中継用）死亡Ｓ（７桁） */
     ztydakuhikettisyacd                                VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定者コード */
     ztydkhktiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）諾否決定年月日 */
     ztydakuhikettikekkacd                              VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定結果コード */
     ztydakuhiketteiriyuucdx1                           VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定理由コード＿１ */
     ztydakuhiketteiriyuucdx2                           VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定理由コード＿２ */
     ztydakuhiketteiriyuucdx3                           VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定理由コード＿３ */
     ztydakuhiketteiriyuucdx4                           VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定理由コード＿４ */
     ztysyukykktkekkacd                                 VARCHAR     (2)                                                                 ,  /* （中継用）主契約決定結果コード */
     ztysntyo3                                          VARCHAR     (3)                                                                 ,  /* （中継用）身長（３文字） */
     ztytijyuu3                                         VARCHAR     (3)                                                                 ,  /* （中継用）体重（３文字） */
     ztybmi                                             DECIMAL     (3)                                                                 ,  /* （中継用）ＢＭＩ */
     ztysinsahouhou                                     VARCHAR     (2)                                                                 ,  /* （中継用）診査方法 */
     ztysyoubyoucd1                                     VARCHAR     (6)                                                                 ,  /* （中継用）傷病コード１ */
     ztykeikanensuux1                                   VARCHAR     (2)                                                                 ,  /* （中継用）経過年数＿１ */
     ztysyoubyoucd2                                     VARCHAR     (6)                                                                 ,  /* （中継用）傷病コード２ */
     ztykeikanensuux2                                   VARCHAR     (2)                                                                 ,  /* （中継用）経過年数＿２ */
     ztysyokaiktisinsahouhou                            VARCHAR     (2)                                                                 ,  /* （中継用）初回決定時診査方法 */
     ztysyokaiktidkhktikekkacd                          VARCHAR     (2)                                                                 ,  /* （中継用）初回決定時諾否決定結果コード */
     ztysyokaiktsyukykktkekkacd                         VARCHAR     (2)                                                                 ,  /* （中継用）初回決定主契約決定結果コード */
     ztyhanbaikeirokbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）販売経路区分 */
     ztyjissituhosyous                                  DECIMAL     (7)                                                                 ,  /* （中継用）実質保障Ｓ */
     ztyoyadairitencd                                   VARCHAR     (7)                                                                 ,  /* （中継用）親代理店コード */
     ztynensyuukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）年収区分 */
     ztysykgycd                                         VARCHAR     (3)                                                                 ,  /* （中継用）職業コード */
     ztysyksbyensitihsyutyhkumu                         VARCHAR     (1)                                                                 ,  /* （中継用）初期死亡時円換算最低保証特約付加有無 */
     ztyjyudkaigomehrtkhkumu                            VARCHAR     (1)                                                                 ,  /* （中継用）重度介護前払特約付加有無 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyijitoukeizennoukbn                              VARCHAR     (1)                                                                 ,  /* （中継用）医事統計用前納区分 */
     ztydai1hknkkn                                      VARCHAR     (2)                                                                 ,  /* （中継用）第１保険期間 */
     ztyijitoukeitikshrtkykkbn                          VARCHAR     (1)                                                                 ,  /* （中継用）医事統計用定期支払特約区分 */
     ztyteikisiharaikinmanen                            DECIMAL     (7)                                                                 ,  /* （中継用）定期支払金（万円） */
     ztyyobiv45                                         VARCHAR     (45)                                                                ,  /* （中継用）予備項目Ｖ４５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_IsaToukeiDataTy_Z ADD CONSTRAINT PK_IsaToukeiDataTy PRIMARY KEY (
     ztymosno                                                   /* （中継用）申込番号 */
) ;
