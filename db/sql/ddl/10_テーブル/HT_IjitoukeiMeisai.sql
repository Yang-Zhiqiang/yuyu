CREATE TABLE HT_IjitoukeiMeisai (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno8keta                                         NUMBER      (8)                                                       NOT NULL  ,  /* 連番（８桁） */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     idousyoriymd                                       VARCHAR     (8)                                                                 ,  /* 異動処理日 */
     sntkhoukbn                                         VARCHAR     (2)                                                                 ,  /* 選択方法区分 */
     kokutikbn                                          VARCHAR     (1)                                                                 ,  /* 告知区分 */
     skeijimukbn                                        VARCHAR     (2)                                                                 ,  /* 新契約事務区分 */
     sirajikykkbn                                       VARCHAR     (1)                                                                 ,  /* 白地契約区分 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     haitoukinuketorihoukbn                             VARCHAR     (1)                                                                 ,  /* 配当金受取方法区分 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     aatsukaishasoshikicd                               VARCHAR     (7)                                                                 ,  /* Ａ扱者組織コード */
     aatukaikojincd                                     VARCHAR     (6)                                                                 ,  /* Ａ扱者個人コード */
     tratkiagcd                                         VARCHAR     (7)                                                                 ,  /* 取扱代理店コード */
     bosyuudairitenatkikeitaikbn                        VARCHAR     (1)                                                                 ,  /* 募集代理店扱形態区分 */
     hhknnen                                            NUMBER      (3)                                                                 ,  /* 被保険者年齢 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknyno                                            VARCHAR     (7)                                                                 ,  /* 被保険者郵便番号 */
     hhkntodouhukencd                                   VARCHAR     (2)                                                                 ,  /* 被保険者都道府県コード */
     hhknnensyuukbn                                     VARCHAR     (2)                                                                 ,  /* 被保険者年収区分 */
     hhknsykgycd                                        VARCHAR     (3)                                                                 ,  /* 被保険者職業コード */
     sintyou                                            NUMBER      (3)                                                                 ,  /* 身長 */
     taijyuu                                            NUMBER      (3)                                                                 ,  /* 体重 */
     kituenkbn                                          VARCHAR     (1)                                                                 ,  /* 喫煙区分 */
     kituenhon                                          NUMBER      (2)                                                                 ,  /* 喫煙本数 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     hrktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 払込通貨種類 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     seitoukihons                                       NUMBER      (13)                                                                ,  /* 正当基本Ｓ */
     seitoukihons$                                      VARCHAR     (10)                                                                ,  /* 正当基本Ｓ(通貨型) */
     seitoukihonsmanen                                  NUMBER      (9)                                                                 ,  /* 正当基本Ｓ（万円） */
     seitoukihonsmanen$                                 VARCHAR     (10)                                                                ,  /* 正当基本Ｓ（万円）(通貨型) */
     syutkp                                             NUMBER      (13)                                                                ,  /* 主契約・特約Ｐ */
     syutkp$                                            VARCHAR     (10)                                                                ,  /* 主契約・特約Ｐ(通貨型) */
     syutkpmanen                                        NUMBER      (9)                                                                 ,  /* 主契約・特約Ｐ（万円） */
     syutkpmanen$                                       VARCHAR     (10)                                                                ,  /* 主契約・特約Ｐ（万円）(通貨型) */
     imustiyusbus                                       NUMBER      (13)                                                                ,  /* 医務査定用死亡Ｓ */
     imustiyusbus$                                      VARCHAR     (10)                                                                ,  /* 医務査定用死亡Ｓ(通貨型) */
     imustiyusbusmanen                                  NUMBER      (9)                                                                 ,  /* 医務査定用死亡Ｓ（万円） */
     imustiyusbusmanen$                                 VARCHAR     (10)                                                                ,  /* 医務査定用死亡Ｓ（万円）(通貨型) */
     yenkansantkykwsrate                                NUMBER      (7,4)                                                               ,  /* 円換算適用為替レート */
     syoubyoucd1                                        VARCHAR     (6)                                                                 ,  /* 傷病コード１ */
     syoubyoucd2                                        VARCHAR     (6)                                                                 ,  /* 傷病コード２ */
     dakuhiktkekkacd                                    VARCHAR     (2)                                                                 ,  /* 諾否決定結果コード */
     dakuhiketsyacd                                     VARCHAR     (15)                                                                ,  /* 諾否決定者コード */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード */
     syksbyensitihsyutkhkkbn                            VARCHAR     (1)                                                                 ,  /* 初期死亡時円換算最低保証特約付加区分 */
     jyudkaigomehrtkhkkbn                               VARCHAR     (1)                                                                 ,  /* 重度介護前払特約付加区分 */
     symtgenincd                                        CHAR        (3)                                                                 ,  /* 消滅原因コード */
     siincd                                             VARCHAR     (3)                                                                 ,  /* 死因コード */
     ijitoukeikaijyokbn                                 VARCHAR     (1)                                                                 ,  /* 医事統計解除区分 */
     sysnikoujiym                                       VARCHAR     (6)                                                                 ,  /* 終身移行時年月 */
     ijitoukeizennoukbn                                 VARCHAR     (1)                                                                 ,  /* 医事統計用前納区分 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     jissituhosyous                                     NUMBER      (13)                                                                ,  /* 実質保障Ｓ */
     jissituhosyous$                                    VARCHAR     (10)                                                                ,  /* 実質保障Ｓ(通貨型) */
     jissituhosyousmanen                                NUMBER      (9)                                                                 ,  /* 実質保障Ｓ（万円） */
     jissituhosyousmanen$                               VARCHAR     (10)                                                                ,  /* 実質保障Ｓ（万円）(通貨型) */
     dai1hknkkn                                         NUMBER      (2)                                                                 ,  /* 第１保険期間 */
     ijitoukeitikshrtkykkbn                             VARCHAR     (1)                                                                 ,  /* 医事統計用定期支払特約区分 */
     teikisiharaikin                                    NUMBER      (13)                                                                ,  /* 定期支払金 */
     teikisiharaikin$                                   VARCHAR     (10)                                                                ,  /* 定期支払金(通貨型) */
     teikisiharaikinmanen                               NUMBER      (9)                                                                 ,  /* 定期支払金（万円） */
     teikisiharaikinmanen$                              VARCHAR     (10)                                                                ,  /* 定期支払金（万円）(通貨型) */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_IjitoukeiMeisai ADD CONSTRAINT PK_IjitoukeiMeisai PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     renno8keta                                                 /* 連番（８桁） */
) ;

CREATE INDEX IX1_IjitoukeiMeisai ON HT_IjitoukeiMeisai (
     syoumetuymd                                                /* 消滅日 */
) ;

CREATE INDEX IX2_IjitoukeiMeisai ON HT_IjitoukeiMeisai (
     kykymd                                                     /* 契約日 */
) ;
