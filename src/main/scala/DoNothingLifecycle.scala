trait DoNothingLifecycle extends Lifecycle {
  def startup(): Unit = {}
  def shutdown(): Unit = {}
}
