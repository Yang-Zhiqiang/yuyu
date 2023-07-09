CREATE TABLE IT_KhTyousyo (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     shrtysyrenno                                       NUMBER      (20)                                                      NOT NULL  ,  /* 支払調書連番 */
     kacd                                               VARCHAR     (3)                                                                 ,  /* 課コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     hknkkn                                             NUMBER      (2)                                                                 ,  /* 保険期間 */
     hrkkkn                                             NUMBER      (2)                                                                 ,  /* 払込期間 */
     hhknnen                                            NUMBER      (3)                                                                 ,  /* 被保険者年齢 */
     kyknen                                             NUMBER      (3)                                                                 ,  /* 契約者年齢 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     annaihuyouriyuukbn                                 VARCHAR     (2)                                                                 ,  /* 案内不要理由区分 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     mfadrsiyouhyouji                                   VARCHAR     (1)                                                                 ,  /* ＭＦ住所使用表示 */
     kihrpdmiseibidisp                                  VARCHAR     (1)                                                                 ,  /* 既払ＰＤ未整備表示 */
     kihrpseibiyoudisp                                  VARCHAR     (1)                                                                 ,  /* 既払込Ｐ整備要表示 */
     shrgk                                              NUMBER      (13)                                                                ,  /* 支払金額 */
     shrgk$                                             VARCHAR     (10)                                                                ,  /* 支払金額(通貨型) */
     warimsishrgkbizc                                   NUMBER      (13)                                                                ,  /* 割増支払金額（業務通貨型） */
     warimsishrgkbizc$                                  VARCHAR     (10)                                                                ,  /* 割増支払金額（業務通貨型）(通貨型) */
     znnphrbizc                                         NUMBER      (13)                                                                ,  /* 前納Ｐ等返戻金（業務通貨型） */
     znnphrbizc$                                        VARCHAR     (10)                                                                ,  /* 前納Ｐ等返戻金（業務通貨型）(通貨型) */
     ttkekstkganribizc                                  NUMBER      (13)                                                                ,  /* 立替貸付元利金（業務通貨型） */
     ttkekstkganribizc$                                 VARCHAR     (10)                                                                ,  /* 立替貸付元利金（業務通貨型）(通貨型) */
     sshkdbizc                                          NUMBER      (13)                                                                ,  /* 差引Ｄ（業務通貨型） */
     sshkdbizc$                                         VARCHAR     (10)                                                                ,  /* 差引Ｄ（業務通貨型）(通貨型) */
     sshkshrgk                                          NUMBER      (13)                                                                ,  /* 差引支払金額 */
     sshkshrgk$                                         VARCHAR     (10)                                                                ,  /* 差引支払金額(通貨型) */
     mihrkmpbizc                                        NUMBER      (13)                                                                ,  /* 未払込Ｐ（業務通貨型） */
     mihrkmpbizc$                                       VARCHAR     (10)                                                                ,  /* 未払込Ｐ（業務通貨型）(通貨型) */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     syoritaisyoukbn                                    VARCHAR     (2)                                                                 ,  /* 処理対象区分 */
     shrtysytsinyno                                     VARCHAR     (7)                                                                 ,  /* 支払調書郵便番号 */
     shrtysyadr1kj                                      VARCHAR     (30)                                                                ,  /* 支払調書住所１（漢字） */
     shrtysyadr2kj                                      VARCHAR     (30)                                                                ,  /* 支払調書住所２（漢字） */
     shrtysyadr3kj                                      VARCHAR     (30)                                                                ,  /* 支払調書住所３（漢字） */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     uktnmkj                                            VARCHAR     (15)                                                                ,  /* 受取人名（漢字） */
     kjdaihyouuktnm                                     VARCHAR     (15)                                                                ,  /* 漢字代表受取人名 */
     shrtienrsk                                         NUMBER      (13)                                                                ,  /* 支払遅延利息 */
     shrtienrsk$                                        VARCHAR     (10)                                                                ,  /* 支払遅延利息(通貨型) */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     shrtysysyuruicd                                    VARCHAR     (1)                                                                 ,  /* 支払調書種類コード */
     teknjikihrpseibidisp                               VARCHAR     (1)                                                                 ,  /* 転換時既払込Ｐ未整備表示 */
     kihrkmp                                            NUMBER      (13)                                                                ,  /* 既払込保険料 */
     kihrkmp$                                           VARCHAR     (10)                                                                ,  /* 既払込保険料(通貨型) */
     onlinecentercutkbn                                 VARCHAR     (1)                                                                 ,  /* オンラインセンターカット区分 */
     shrhousiteikbn                                     VARCHAR     (1)                                                                 ,  /* 支払方法指定区分 */
     htykeihihnsyukbn                                   VARCHAR     (1)                                                                 ,  /* 必要経費編集区分 */
     syuseijtshrdbizc                                   NUMBER      (13)                                                                ,  /* 修正後実支払Ｄ（業務通貨型） */
     syuseijtshrdbizc$                                  VARCHAR     (10)                                                                ,  /* 修正後実支払Ｄ（業務通貨型）(通貨型) */
     touduketorihouhoukbn                               VARCHAR     (1)                                                                 ,  /* 当Ｄ受取方法区分 */
     nenkinkkn                                          NUMBER      (2)                                                                 ,  /* 年金期間 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     banknmkn                                           VARCHAR     (25)                                                                ,  /* 銀行名（カナ） */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     sitennmkn                                          VARCHAR     (25)                                                                ,  /* 支店名（カナ） */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     yokinknmkn                                         VARCHAR     (7)                                                                 ,  /* 預金口座種目名（カナ） */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     sakuseiymd                                         VARCHAR     (8)                                                                 ,  /* 作成年月日 */
     kykmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 契約者ＭＮ名義番号 */
     uktmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 受取人ＭＮ名義番号 */
     jigyoukykmndantaicd                                VARCHAR     (8)                                                                 ,  /* 事業契約用ＭＮ団体コード */
     mnsaiannaihnskakbn                                 VARCHAR     (2)                                                                 ,  /* ＭＮ再案内本社回送区分 */
     huho2kykdisp                                       VARCHAR     (1)                                                                 ,  /* 普保Ⅱ契約表示 */
     shrtysyhknsyukbn                                   VARCHAR     (2)                                                                 ,  /* 支払調書保険種類区分 */
     shrtysykurikosidisp                                VARCHAR     (1)                                                                 ,  /* 支払調書繰越表示 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     synyhsjykykndisp                                   VARCHAR     (1)                                                                 ,  /* 収入保障年金受給権表示 */
     tblsakuseihunodisp                                 VARCHAR     (1)                                                                 ,  /* テープ作成不能表示 */
     daihyouktkbn                                       VARCHAR     (1)                                                                 ,  /* 代表受取人区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     oldtsinyno                                         VARCHAR     (7)                                                                 ,  /* （旧）通信先郵便番号 */
     oldtsinadr1kj                                      VARCHAR     (30)                                                                ,  /* （旧）通信先住所１（漢字） */
     oldtsinadr2kj                                      VARCHAR     (30)                                                                ,  /* （旧）通信先住所２（漢字） */
     oldtsinadr3kj                                      VARCHAR     (30)                                                                ,  /* （旧）通信先住所３（漢字） */
     oldkyknmkj                                         VARCHAR     (15)                                                                ,  /* （旧）契約者名（漢字） */
     kykhnkkaisuu                                       NUMBER      (2)                                                                 ,  /* 契約者変更回数 */
     shrkykhtykeihiyouhyj                               VARCHAR     (1)                                                                 ,  /* 支払時契約者必要経費要表示 */
     shrkykhtykeihi                                     NUMBER      (13)                                                                ,  /* 支払時契約者必要経費 */
     shrkykhtykeihi$                                    VARCHAR     (10)                                                                   /* 支払時契約者必要経費(通貨型) */
)
;

ALTER TABLE IT_KhTyousyo ADD CONSTRAINT PK_KhTyousyo PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                              , /* 帳票作成日 */
     shrtysyrenno                                               /* 支払調書連番 */
) ;
