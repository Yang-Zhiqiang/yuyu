CREATE TABLE IT_KhIdouTyousyo (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     shrtysyrenno                                       NUMBER      (20)                                                      NOT NULL  ,  /* 支払調書連番 */
     kacd                                               VARCHAR     (3)                                                                 ,  /* 課コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     shrtysysyuruicd                                    VARCHAR     (1)                                                                 ,  /* 支払調書種類コード */
     syoritaisyoukbn                                    VARCHAR     (2)                                                                 ,  /* 処理対象区分 */
     tblsakuseihunodisp                                 VARCHAR     (1)                                                                 ,  /* テープ作成不能表示 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     oldtsinyno                                         VARCHAR     (7)                                                                 ,  /* （旧）通信先郵便番号 */
     oldtsinadr1kj                                      VARCHAR     (30)                                                                ,  /* （旧）通信先住所１（漢字） */
     oldtsinadr2kj                                      VARCHAR     (30)                                                                ,  /* （旧）通信先住所２（漢字） */
     oldtsinadr3kj                                      VARCHAR     (30)                                                                ,  /* （旧）通信先住所３（漢字） */
     oldkyknmkj                                         VARCHAR     (15)                                                                ,  /* （旧）契約者名（漢字） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     oldkyksibouymd                                     VARCHAR     (8)                                                                 ,  /* （旧）契約者死亡日 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     kyksiboumeighnksyoriymd                            VARCHAR     (8)                                                                 ,  /* 契約者死亡名義変更処理年月日 */
     kaiyakuhrstgk                                      VARCHAR     (13)                                                                ,  /* 解約返戻金相当額 */
     kaiyakuhrstgk$                                     VARCHAR     (10)                                                                ,  /* 解約返戻金相当額(通貨型) */
     kihrkmp                                            NUMBER      (13)                                                                ,  /* 既払込保険料 */
     kihrkmp$                                           VARCHAR     (10)                                                                ,  /* 既払込保険料(通貨型) */
     oldkykkihrkmpyouhyj                                VARCHAR     (1)                                                                 ,  /* （旧）契約者既払込保険料要表示 */
     oldkykkihrkmp                                      VARCHAR     (13)                                                                ,  /* （旧）契約者既払込保険料 */
     oldkykkihrkmp$                                     VARCHAR     (10)                                                                ,  /* （旧）契約者既払込保険料(通貨型) */
     sakuseiymd                                         VARCHAR     (8)                                                                 ,  /* 作成年月日 */
     huho2kykdisp                                       VARCHAR     (1)                                                                 ,  /* 普保Ⅱ契約表示 */
     shrtysyhknsyukbn                                   VARCHAR     (2)                                                                 ,  /* 支払調書保険種類区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhIdouTyousyo ADD CONSTRAINT PK_KhIdouTyousyo PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                              , /* 帳票作成日 */
     shrtysyrenno                                               /* 支払調書連番 */
) ;
