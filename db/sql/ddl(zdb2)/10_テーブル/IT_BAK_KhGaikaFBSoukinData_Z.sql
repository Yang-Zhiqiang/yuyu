CREATE TABLE IT_BAK_KhGaikaFBSoukinData_Z (
     fbsoukindatasikibetukey                            VARCHAR     (20)                                                      NOT NULL  ,  /* ＦＢ送金データ識別キー */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                                 ,  /* 枝番号 */
     densyskbn                                          VARCHAR     (2)                                                                 ,  /* 伝票用システム区分 */
     gkgyoumucd                                         VARCHAR     (5)                                                                 ,  /* 外貨業務コード */
     tantositucd                                        VARCHAR     (3)                                                                 ,  /* 担当室コード */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     shrhousiteikbn                                     VARCHAR     (1)                                                                 ,  /* 支払方法指定区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     banknmej                                           VARCHAR     (60)                                                                ,  /* 銀行名（英字） */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     sitennmej                                          VARCHAR     (60)                                                                ,  /* 支店名（英字） */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmei                                        VARCHAR     (140)                                                               ,  /* 口座名義人名（英字） */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     gaikashrgk                                         DECIMAL     (15)                                                                ,  /* 外貨支払額 */
     gaikashrgk$                                        VARCHAR     (10)                                                                ,  /* 外貨支払額(通貨型) */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     crossrateshrgk                                     DECIMAL     (15)                                                                ,  /* クロスレート支払額 */
     crossrateshrgk$                                    VARCHAR     (10)                                                                ,  /* クロスレート支払額(通貨型) */
     soukinkwsrate                                      DECIMAL     (7,4)                                                               ,  /* 送金用為替レート */
     irninnmei                                          VARCHAR     (140)                                                               ,  /* 依頼人名（英字） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_KhGaikaFBSoukinData_Z ADD CONSTRAINT PK_BAK_KhGaikaFBSoukinData PRIMARY KEY (
     fbsoukindatasikibetukey                                  , /* ＦＢ送金データ識別キー */
     trkssikibetukey                                            /* 取消識別キー */
) ;
