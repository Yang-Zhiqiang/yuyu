CREATE VIEW HT_BosUketorinin AS SELECT
     mosno ,         /* 申込番号 */
     uktsyukbn ,         /* 受取人種類区分 */
     uktsyurenno ,         /* 受取人種類別連番 */
     uktkbn ,         /* 受取人区分 */
     uktnmkn ,         /* 受取人名（カナ） */
     uktnmkj ,         /* 受取人名（漢字） */
     uktnmkjkhukakbn ,         /* 受取人名漢字化不可区分 */
     ukttdk ,         /* 受取人続柄 */
     uktbnwari ,         /* 受取人分割割合 */
     uktseiymd ,         /* 受取人生年月日 */
     ukttsindousiteikbn ,         /* 受取人通信先同一指定区分 */
     uktyno ,         /* 受取人郵便番号 */
     uktadr1kj ,         /* 受取人住所１（漢字） */
     uktadr2kj ,         /* 受取人住所２（漢字） */
     uktadr3kj ,         /* 受取人住所３（漢字） */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_BosUketorinin_Z;