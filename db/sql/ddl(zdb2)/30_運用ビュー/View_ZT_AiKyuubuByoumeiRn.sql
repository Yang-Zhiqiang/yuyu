CREATE VIEW ZT_AiKyuubuByoumeiRn AS SELECT
     zrnbyoumeitourokuno ,         /* （連携用）病名登録番号 */
     zrnbyoumei ,         /* （連携用）病名 */
     zrnbyoumeizenkaku ,         /* （連携用）病名全角 */
     zrnbyoumeihurigana ,         /* （連携用）病名フリガナ */
     zrnbyoumeihuriganakensaku ,         /* （連携用）病名フリガナ検索用 */
     zrnbyoumeicd ,         /* （連携用）病名コード */
     zrnbyoumeibuicd ,         /* （連携用）病名部位コード */
     zrngaitoukbn1 ,         /* （連携用）該当区分１ */
     zrngaitoukbn2 ,         /* （連携用）該当区分２ */
     zrngaitoukbn3 ,         /* （連携用）該当区分３ */
     zrngaitoukbn4 ,         /* （連携用）該当区分４ */
     zrngaitoukbn5 ,         /* （連携用）該当区分５ */
     zrntyuuimongon           /* （連携用）注意文言 */
FROM ZT_AiKyuubuByoumeiRn_Z;