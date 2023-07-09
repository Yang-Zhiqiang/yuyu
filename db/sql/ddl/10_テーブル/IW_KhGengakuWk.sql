CREATE TABLE IW_KhGengakuWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     kykhnkkbn                                          VARCHAR     (1)                                                                 ,  /* 契約変更区分 */
     gengkhoukbn                                        VARCHAR     (1)                                                                 ,  /* 減額方法区分 */
     newkihonhknkngaku                                  NUMBER      (13)                                                                ,  /* 新基本保険金額 */
     newkihonhknkngaku$                                 VARCHAR     (10)                                                                ,  /* 新基本保険金額(通貨型) */
     newhrkp                                            NUMBER      (13)                                                                ,  /* 新払込保険料 */
     newhrkp$                                           VARCHAR     (10)                                                                ,  /* 新払込保険料(通貨型) */
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
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     soukinsakikbn                                      VARCHAR     (1)                                                                    /* 送金先区分 */
)
;

ALTER TABLE IW_KhGengakuWk ADD CONSTRAINT PK_KhGengakuWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
