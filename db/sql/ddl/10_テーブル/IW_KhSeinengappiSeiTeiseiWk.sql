CREATE TABLE IW_KhSeinengappiSeiTeiseiWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     newhhknseiymd                                      VARCHAR     (8)                                                                 ,  /* 変更後被保険者生年月日 */
     newhhknsei                                         VARCHAR     (1)                                                                 ,  /* 変更後被保険者性別 */
     yenshrtkhkumu                                      VARCHAR     (1)                                                                 ,  /* 円支払特約付加有無 */
     inputshrhousiteikbn                                VARCHAR     (1)                                                                 ,  /* 入力用支払方法指定区分 */
     soukinsakikbn                                      VARCHAR     (1)                                                                 ,  /* 送金先区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分 */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     syorikbn                                           VARCHAR     (2)                                                                    /* 処理区分 */
)
;

ALTER TABLE IW_KhSeinengappiSeiTeiseiWk ADD CONSTRAINT PK_KhSeinengappiSeiTeiseiWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
