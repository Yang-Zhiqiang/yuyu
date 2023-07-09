CREATE TABLE IT_GinkouMdhnFollowCall_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kyksakuinmeino                                     VARCHAR     (10)                                                                ,  /* 契約者索引名番号 */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     followcallsyorikbn                                 VARCHAR     (1)                                                                 ,  /* フォローコール処理区分 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     bsyujdrtencd1                                      VARCHAR     (7)                                                                 ,  /* 募集時代理店コード１ */
     bsyujbosyuucd1                                     VARCHAR     (6)                                                                 ,  /* 募集時募集人コード１ */
     bsyujdrtencd2                                      VARCHAR     (7)                                                                 ,  /* 募集時代理店コード２ */
     bsyujbosyuucd2                                     VARCHAR     (6)                                                                 ,  /* 募集時募集人コード２ */
     bsyujdrtencd3                                      VARCHAR     (7)                                                                 ,  /* 募集時代理店コード３ */
     bsyujbosyuucd3                                     VARCHAR     (6)                                                                 ,  /* 募集時募集人コード３ */
     bsyujdrtencd4                                      VARCHAR     (7)                                                                 ,  /* 募集時代理店コード４ */
     bsyujbosyuucd4                                     VARCHAR     (6)                                                                 ,  /* 募集時募集人コード４ */
     bsyujdrtencd5                                      VARCHAR     (7)                                                                 ,  /* 募集時代理店コード５ */
     bsyujbosyuucd5                                     VARCHAR     (6)                                                                 ,  /* 募集時募集人コード５ */
     saisindrtencd                                      VARCHAR     (7)                                                                 ,  /* 最新代理店コード */
     saisinbosyuucd                                     VARCHAR     (6)                                                                 ,  /* 最新募集人コード */
     syouhnnm                                           VARCHAR     (82)                                                                ,  /* 商品名 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     annaigk                                            DECIMAL     (13)                                                                ,  /* 案内金額 */
     annaigk$                                           VARCHAR     (10)                                                                ,  /* 案内金額(通貨型) */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     fchrkkaisuu                                        VARCHAR     (1)                                                                 ,  /* フォローコール払込回数 */
     anniskcd                                           VARCHAR     (8)                                                                 ,  /* 案内先コード */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     minyuym                                            VARCHAR     (6)                                                                 ,  /* 未入年月 */
     kyknmhnykkbn                                       VARCHAR     (1)                                                                 ,  /* 契約者名翻訳結果区分 */
     hhknnmhnykkbn                                      VARCHAR     (1)                                                                 ,  /* 被保険者名翻訳結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_GinkouMdhnFollowCall_Z ADD CONSTRAINT PK_GinkouMdhnFollowCall PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syoriYmd                                                 , /* 処理年月日 */
     syono                                                      /* 証券番号 */
) ;
