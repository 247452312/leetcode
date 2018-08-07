select Score,
(
select count(DISTINCT Score)
from Scores as b
where s.Score<b.Score)+1 as Rank from Scores s order by Score desc