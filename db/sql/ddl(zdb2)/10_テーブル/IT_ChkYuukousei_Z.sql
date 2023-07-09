CREATE TABLE IT_ChkYuukousei_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限 */
     yuukoutaisyouym                                    VARCHAR     (6)                                                                 ,  /* 有効性確認対象年月 */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     hokensyuruikigousdicode                            VARCHAR     (1)                                                                 ,  /* 保険種類記号世代コード */
     hknsyukigoukktkmk1                                 DECIMAL     (15)                                                                ,  /* 保険種類記号拡張項目１ */
     hknsyukigoukktkmk2                                 VARCHAR     (10)                                                                ,  /* 保険種類記号拡張項目２ */
     hknsyukigoukktkmk3                                 DECIMAL     (10)                                                                ,  /* 保険種類記号拡張項目３ */
     kameitenno                                         VARCHAR     (15)                                                                ,  /* 加盟店番号 */
     kameitennm                                         VARCHAR     (15)                                                                ,  /* 加盟店名 */
     gaiburenkeikakujkkbn                               VARCHAR     (1)                                                                 ,  /* 外部連携確認状況区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_ChkYuukousei_Z ADD CONSTRAINT PK_ChkYuukousei PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     syono                                                      /* 証券番号 */
) ;
