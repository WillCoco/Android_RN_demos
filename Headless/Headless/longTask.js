const longTask = () => {
  let a = 0;
  for (let i = 0; i < 5000000000; i++) {
    a = a + i
  }
  return a
};

module.exports = longTask;