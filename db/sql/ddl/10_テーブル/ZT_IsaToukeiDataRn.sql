CREATE TABLE ZT_IsaToukeiDataRn (
     zrnmosno                                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）申込番号 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhjykktkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）報状告知区分 */
     zrnhknsyuruicd                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類コード */
     zrnhrkhuhukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込方法区分 */
     zrnmossyoumetukbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込消滅区分 */
     zrnmusymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込年月日 */
     zrnmosym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）申込月度 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnaatukaisosikicd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者組織コード */
     zrnaatukaikojincd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ａ扱者個人コード */
     zrnhhknnen3                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）被保険者年令（３文字） */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnkyktuuka                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約通貨 */
     zrnsibous7                                         NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）死亡Ｓ（７桁） */
     zrndakuhikettisyacd                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定者コード */
     zrndkhktiymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）諾否決定年月日 */
     zrndakuhikettikekkacd                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定結果コード */
     zrndakuhiketteiriyuucdx1                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定理由コード＿１ */
     zrndakuhiketteiriyuucdx2                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定理由コード＿２ */
     zrndakuhiketteiriyuucdx3                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定理由コード＿３ */
     zrndakuhiketteiriyuucdx4                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定理由コード＿４ */
     zrnsyukykktkekkacd                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約決定結果コード */
     zrnsntyo3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）身長（３文字） */
     zrntijyuu3                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）体重（３文字） */
     zrnbmi                                             NUMBER      (3)                                                       NOT NULL  ,  /* （連携用）ＢＭＩ */
     zrnsinsahouhou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）診査方法 */
     zrnsyoubyoucd1                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）傷病コード１ */
     zrnkeikanensuux1                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）経過年数＿１ */
     zrnsyoubyoucd2                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）傷病コード２ */
     zrnkeikanensuux2                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）経過年数＿２ */
     zrnsyokaiktisinsahouhou                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）初回決定時診査方法 */
     zrnsyokaiktidkhktikekkacd                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）初回決定時諾否決定結果コード */
     zrnsyokaiktsyukykktkekkacd                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）初回決定主契約決定結果コード */
     zrnhanbaikeirokbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）販売経路区分 */
     zrnjissituhosyous                                  NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）実質保障Ｓ */
     zrnoyadairitencd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）親代理店コード */
     zrnnensyuukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年収区分 */
     zrnsykgycd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）職業コード */
     zrnsyksbyensitihsyutyhkumu                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初期死亡時円換算最低保証特約付加有無 */
     zrnjyudkaigomehrtkhkumu                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）重度介護前払特約付加有無 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnijitoukeizennoukbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）医事統計用前納区分 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnijitoukeitikshrtkykkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）医事統計用定期支払特約区分 */
     zrnteikisiharaikinmanen                            NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）定期支払金（万円） */
     zrnyobiv45                                         CHAR        (45)                                                      NOT NULL     /* （連携用）予備項目Ｖ４５ */
)
;

ALTER TABLE ZT_IsaToukeiDataRn ADD CONSTRAINT PK_IsaToukeiDataRn PRIMARY KEY (
     zrnmosno                                                   /* （連携用）申込番号 */
) ;
