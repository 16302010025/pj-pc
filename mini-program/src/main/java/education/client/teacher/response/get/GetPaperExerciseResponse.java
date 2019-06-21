package education.client.teacher.response.get;

import education.entity.ExerciseWithBLOBs;

import java.util.List;

public class GetPaperExerciseResponse {
  List<ExerciseWithBLOBs> exerciseWithBLOBs;

  public GetPaperExerciseResponse(List<ExerciseWithBLOBs> exerciseWithBLOBs) {
    this.exerciseWithBLOBs = exerciseWithBLOBs;
  }

  public List<ExerciseWithBLOBs> getExerciseWithBLOBs() {
    return exerciseWithBLOBs;
  }

  public void setExerciseWithBLOBs(List<ExerciseWithBLOBs> exerciseWithBLOBs) {
    this.exerciseWithBLOBs = exerciseWithBLOBs;
  }
}
