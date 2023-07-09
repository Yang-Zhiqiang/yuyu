CREATE TABLE IT_KhHenkouUktkKaiyaku (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hozenhenkouuktkrenno                               NUMBER      (5)                                                       NOT NULL  ,  /* 保全変更受付連番 */
     inputshrhousiteikbn                                VARCHAR     (1)                                                                 ,  /* 入力用支払方法指定区分 */
     yenshrtkhkumu                                      VARCHAR     (1)                                                                 ,  /* 円支払特約付加有無 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhHenkouUktkKaiyaku ADD CONSTRAINT PK_KhHenkouUktkKaiyaku PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     hozenhenkouuktkrenno                                       /* 保全変更受付連番 */
) ;
