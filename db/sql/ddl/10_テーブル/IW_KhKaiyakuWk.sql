CREATE TABLE IW_KhKaiyakuWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     kaiyakujiyuu                                       VARCHAR     (1)                                                                 ,  /* 解約事由 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     shnmkj                                             VARCHAR     (30)                                                                ,  /* 送付先氏名（漢字）（３０桁） */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
     kyksyaszknmkn                                      VARCHAR     (18)                                                                ,  /* 契約者相続人氏名（カナ） */
     kyksyaszknmkj                                      VARCHAR     (15)                                                                ,  /* 契約者相続人氏名（漢字） */
     kyksyaszkyno                                       VARCHAR     (7)                                                                 ,  /* 契約者相続人郵便番号 */
     kyksyaszkadr1kj                                    VARCHAR     (30)                                                                ,  /* 契約者相続人住所１（漢字） */
     kyksyaszkadr2kj                                    VARCHAR     (30)                                                                ,  /* 契約者相続人住所２（漢字） */
     kyksyaszkadr3kj                                    VARCHAR     (30)                                                                ,  /* 契約者相続人住所３（漢字） */
     saikennmkj                                         VARCHAR     (30)                                                                ,  /* 債権者氏名（漢字） */
     saikennyno                                         VARCHAR     (7)                                                                 ,  /* 債権者郵便番号 */
     saikenadr1kj                                       VARCHAR     (30)                                                                ,  /* 債権者住所１（漢字） */
     saikenadr2kj                                       VARCHAR     (30)                                                                ,  /* 債権者住所２（漢字） */
     saikenadr3kj                                       VARCHAR     (30)                                                                ,  /* 債権者住所３（漢字） */
     yenshrtkhkumu                                      VARCHAR     (1)                                                                 ,  /* 円支払特約付加有無 */
     inputshrhousiteikbn                                VARCHAR     (1)                                                                 ,  /* 入力用支払方法指定区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     kykmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 契約者ＭＮ名義番号 */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分 */
     kanryotuutioutkbn                                  VARCHAR     (1)                                                                 ,  /* 完了通知出力区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     uktmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 受取人ＭＮ名義番号 */
     soukinsakikbn                                      VARCHAR     (1)                                                                    /* 送金先区分 */
)
;

ALTER TABLE IW_KhKaiyakuWk ADD CONSTRAINT PK_KhKaiyakuWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
